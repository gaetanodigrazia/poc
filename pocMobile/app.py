import streamlit as st
import requests
from datetime import date

API_BASE = "http://host.docker.internal:8080/api/v1"
KAFKA_API_BASE = "http://host.docker.internal:8084/api/v1"

st.title("Sistema Prenotazioni - MVP (Ricerca Avanzata)")

# 1. Dati paziente
st.subheader("1. Inserisci dati del paziente")
utente_id = st.text_input("ID utente (manuale)")
nome_paziente = st.text_input("Nome completo")
email_paziente = st.text_input("Email")
telefono_paziente = st.text_input("Numero di telefono")

# 2. Caricamento filtri
st.subheader("2. Filtra per Dottore, Sede o Prestazione")

# Carica dottori
dottori = []
try:
    r = requests.get(f"{API_BASE}/dottore")
    if r.ok:
        dottori = r.json()
except:
    st.warning("Dottori non disponibili")

# Carica sedi
sedi = []
try:
    r = requests.get(f"{API_BASE}/sedi")
    if r.ok:
        sedi = r.json()
except:
    st.warning("Sedi non disponibili")

# Carica prestazioni
prestazioni = []
try:
    r = requests.get(f"{API_BASE}/prestazione")
    if r.ok:
        prestazioni = r.json()
except:
    st.warning("Prestazioni non disponibili")

# Select per filtro
selected_dottore = st.selectbox("Dottore", ["Tutti"] + [f"{d['nome']} ({d['id']})" for d in dottori])
selected_sede = st.selectbox("Sede", ["Tutti"] + [f"{s['nome']} - {s['citta']} ({s['id']})" for s in sedi])
selected_prestazione = st.selectbox("Prestazione", ["Tutti"] + [f"{p['nome']} ({p['id']})" for p in prestazioni])

# Costruisci params
params = {}
if selected_dottore != "Tutti":
    params["dottoreId"] = next(d["id"] for d in dottori if f"{d['nome']} ({d['id']})" == selected_dottore)
if selected_sede != "Tutti":
    params["sedeId"] = next(s["id"] for s in sedi if f"{s['nome']} - {s['citta']} ({s['id']})" == selected_sede)
if selected_prestazione != "Tutti":
    params["prestazioneId"] = next(p["id"] for p in prestazioni if f"{p['nome']} ({p['id']})" == selected_prestazione)

# 3. Disponibilità filtrate
st.subheader("3. Seleziona disponibilità")

try:
    r = requests.get(f"{API_BASE}/disponibilita", params=params)
    if r.ok:
        disponibilita = r.json()
        disp_options = {
            f"{d['giorno']} {d['orario']} (ID: {d['id']})": d['id'] for d in disponibilita
        }
        if disp_options:
            selected_disp = st.selectbox("Disponibilità", list(disp_options.keys()))
            disponibilita_id = disp_options[selected_disp]
        else:
            st.warning("Nessuna disponibilità trovata.")
            disponibilita_id = None
    else:
        st.error("Errore nel recupero delle disponibilità.")
        disponibilita_id = None
except Exception as e:
    st.error(f"Errore connessione disponibilità: {e}")
    disponibilita_id = None

# 4. Conferma prenotazione
st.subheader("4. Conferma prenotazione")
data_prenotazione = st.date_input("Data prenotazione", value=date.today())

if st.button("Prenota"):
    if utente_id and nome_paziente and email_paziente and telefono_paziente and disponibilita_id:
        prenotazione = {
            "id": f"pr-{date.today()}-{disponibilita_id}",
            "utenteId": utente_id,
            "disponibilitaId": disponibilita_id,
            "data": str(data_prenotazione)
        }
        try:
            response = requests.post(f"{KAFKA_API_BASE}/prenotazioni", json=prenotazione)
            if response.ok:
                st.success(f"Prenotazione inviata correttamente per {nome_paziente}")
            else:
                st.error(f"Errore invio (status: {response.status_code})")
        except Exception as e:
            st.error(f"Errore connessione al producer Kafka: {e}")
    else:
        st.error("Compila tutti i campi richiesti.")
