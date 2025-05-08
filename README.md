
# 🩺 Sistema Prenotazioni - Proof of Concept (POC)

Questo progetto è una dimostrazione di un'architettura **a microservizi** per un sistema di prenotazioni mediche, basata su **CQRS**, **Apache Kafka**, **Spring Boot**, **MySQL**, e **Streamlit**.

## 📁 Struttura del Progetto

La cartella principale `poc/` contiene:

- `docker-compose.yml`: orchestrazione completa
- `pocDataRetrieval/`: servizio REST per il retrieval dei dati (Query API)
- `pocBookingProducer/`: microservizio per invio prenotazioni → Kafka
- `pocBookingConsumer/`: microservizio consumer Kafka → scrittura DB
- `pocMobile/`: frontend Streamlit per pazienti
- `pocDashboard/`: frontend Streamlit per operatori/medici
- `docker/flyway/`: gestione migrazioni SQL

## ⚙️ Requisiti

- Docker + Docker Compose
- Git (per scaricare i moduli)

## 🚀 Avvio del progetto

1. **Clona o scarica tutti i microservizi** dentro la cartella `poc/`
    ```bash
    git clone https://github.com/gaetanodigrazia/poc
    cd poc
    git clone https://github.com/gaetanodigrazia/pocDataRetrieval
    git clone https://github.com/gaetanodigrazia/pocBookingProducer
    git clone https://github.com/gaetanodigrazia/pocBookingConsumer
    git clone https://github.com/gaetanodigrazia/pocMobile
    git clone https://github.com/gaetanodigrazia/pocDashboard
    ```

2. **Avvia tutti i servizi**:

    ```bash
    docker compose up --build
    ```

3. **Dopo il primo avvio**, riavvia manualmente i seguenti servizi (per assicurare l'inizializzazione completa del DB):

    ```bash
    docker compose restart flyway
    docker compose restart pocdataretrieval
    docker compose restart pocbookingconsumer
    ```

---

## 🌍 Servizi esposti

| Servizio              | URL / Porta         | Descrizione                     |
|-----------------------|---------------------|---------------------------------|
| Kafka UI (Kafdrop)    | `http://localhost:9000` | Monitoraggio Kafka topics     |
| Frontend (Pazienti)   | `http://localhost:8501` | Prenotazioni via Streamlit    |
| Dashboard (Operatori) | `http://localhost:8502` | Esiti e prenotazioni           |
| REST API Dati         | `http://localhost:8080` | Dati su dottori, prestazioni   |
| Kafka Producer API    | `http://localhost:8084` | Invia prenotazioni a Kafka     |

---

## 📐 Architettura

- CQRS: separazione tra comando (producer) e query (retrieval)
- Kafka: evento `PrenotazioneCreata`
- MySQL: replicabile per query/consistency
- Flyway: gestione delle migrazioni SQL
- Streamlit: frontend rapido per demo MVP

---

## 📄 License

MIT - Free to use & modify

---

> Progetto POC per scopi formativi e dimostrativi.
