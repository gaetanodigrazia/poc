
import streamlit as st
import requests

API_BASE = "http://host.docker.internal:8080/api/v1"

# Sidebar con pulsanti per simulare la navigazione
st.sidebar.title("Navigazione")
if "pagina" not in st.session_state:
    st.session_state["pagina"] = "Gestione Prenotazioni"

if st.sidebar.button("Gestione Prenotazioni"):
    st.session_state["pagina"] = "Gestione Prenotazioni"
if st.sidebar.button("Gestione Esiti"):
    st.session_state["pagina"] = "Gestione Esiti"

st.title("Dashboard Prenotazioni ed Esiti")

# -------------------- GESTIONE PRENOTAZIONI --------------------
if st.session_state["pagina"] == "Gestione Prenotazioni":
    st.header("📋 Prenotazioni registrate")

    try:
        response = requests.get(f"{API_BASE}/prenotazioni")
        if response.ok:
            prenotazioni = response.json()
            if prenotazioni:
                for p in prenotazioni:
                    with st.expander(f"Prenotazione {p['id']}"):
                        st.write(f"**Utente ID:** {p['utenteId']}")
                        st.write(f"**Disponibilità ID:** {p['disponibilitaId']}")
                        st.write(f"**Data:** {p['data']}")
            else:
                st.info("Nessuna prenotazione presente.")
        else:
            st.error("Errore nel recupero delle prenotazioni.")
    except Exception as e:
        st.error(f"Errore nella connessione al backend: {e}")

    st.header("📝 Inserisci Esito per Prenotazione")

    try:
        response = requests.get(f"{API_BASE}/prenotazioni")
        if response.ok:
            prenotazioni = response.json()
            prenotazione_options = {f"{p['id']} ({p['data']})": p['id'] for p in prenotazioni}
            selected_prenotazione = st.selectbox("Seleziona Prenotazione", options=list(prenotazione_options.keys()))
            prenotazione_id = prenotazione_options[selected_prenotazione]

            descrizione = st.text_area("Descrizione dell'esito")
            prescrizioni = st.text_area("Prescrizioni")

            if st.button("Salva Esito"):
                payload = {
                    "prenotazioneId": prenotazione_id,
                    "descrizione": descrizione,
                    "prescrizioni": prescrizioni
                }

                try:
                    post_resp = requests.post(f"{API_BASE}/esiti", json=payload)
                    if post_resp.ok:
                        st.success("Esito salvato correttamente.")
                    else:
                        st.error(f"Errore durante il salvataggio dell'esito (status: {post_resp.status_code})")
                except Exception as e:
                    st.error(f"Errore di connessione al backend: {e}")
        else:
            st.error("Errore nel recupero delle prenotazioni per inserimento esito.")
    except Exception as e:
        st.error(f"Errore nella connessione al backend: {e}")

# -------------------- GESTIONE ESITI --------------------
elif st.session_state["pagina"] == "Gestione Esiti":
    st.header("🗃️ Esiti salvati")

    try:
        response = requests.get(f"{API_BASE}/esiti")
        if response.ok:
            esiti = response.json()
            if esiti:
                for e in esiti:
                    key_prefix = f"{e['id']}"
                    if f"edit_mode_{key_prefix}" not in st.session_state:
                        st.session_state[f"edit_mode_{key_prefix}"] = False

                    with st.expander(f"Esito {e['id']} (Prenotazione {e['prenotazioneId']})"):
                        if st.session_state[f"edit_mode_{key_prefix}"]:
                            descr = st.text_area("Descrizione", value=e["descrizione"], key=f"desc-{key_prefix}")
                            prescr = st.text_area("Prescrizioni", value=e["prescrizioni"], key=f"presc-{key_prefix}")
                            if st.button("Salva", key=f"save-{key_prefix}"):
                                updated = {
                                    "id": e["id"],
                                    "prenotazioneId": e["prenotazioneId"],
                                    "descrizione": descr,
                                    "prescrizioni": prescr
                                }
                                try:
                                    put_resp = requests.put(f"{API_BASE}/esiti/{e['id']}", json=updated)
                                    if put_resp.ok:
                                        st.success("Esito aggiornato.")
                                        st.session_state[f"edit_mode_{key_prefix}"] = False
                                    else:
                                        st.error(f"Errore aggiornamento ({put_resp.status_code})")
                                except Exception as ex:
                                    st.error(f"Errore: {ex}")
                        else:
                            st.markdown(f"**Descrizione:** {e['descrizione']}")
                            st.markdown(f"**Prescrizioni:** {e['prescrizioni']}")

                        col1, col2 = st.columns(2)
                        with col1:
                            if not st.session_state[f"edit_mode_{key_prefix}"]:
                                if st.button("Modifica", key=f"edit-{key_prefix}"):
                                    st.session_state[f"edit_mode_{key_prefix}"] = True
                        with col2:
                            if st.button("Elimina", key=f"delete-{key_prefix}"):
                                try:
                                    del_resp = requests.delete(f"{API_BASE}/esiti/{e['id']}")
                                    if del_resp.ok:
                                        st.success("Esito eliminato.")
                                    else:
                                        st.error(f"Errore eliminazione ({del_resp.status_code})")
                                except Exception as ex:
                                    st.error(f"Errore: {ex}")
            else:
                st.info("Nessun esito salvato.")
        else:
            st.error("Errore nel recupero degli esiti.")
    except Exception as e:
        st.error(f"Errore nella connessione al backend: {e}")
