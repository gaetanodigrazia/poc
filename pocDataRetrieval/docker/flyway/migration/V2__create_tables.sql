USE poc;
-- V1__init_schema_with_data_varchar_not_null.sql

-- Table: utente
CREATE TABLE IF NOT EXISTS utente (
                                      id VARCHAR(255) NOT NULL PRIMARY KEY,
                                      nome VARCHAR(255) NOT NULL,
                                      email VARCHAR(255) NOT NULL,
                                      telefono VARCHAR(50) NOT NULL
);

-- Table: dottore
CREATE TABLE IF NOT EXISTS dottore (
                                       id VARCHAR(255) NOT NULL PRIMARY KEY,
                                       nome VARCHAR(255) NOT NULL,
                                       email VARCHAR(255) NOT NULL,
                                       telefono VARCHAR(50) NOT NULL
);

-- Table: prestazione
CREATE TABLE IF NOT EXISTS prestazione (
                                           id VARCHAR(255) NOT NULL PRIMARY KEY,
                                           nome VARCHAR(255) NOT NULL,
                                           costo DOUBLE NOT NULL
);

-- Table: disponibilita
CREATE TABLE IF NOT EXISTS disponibilita (
                                             id VARCHAR(255) NOT NULL PRIMARY KEY,
                                             giorno DATE NOT NULL,
                                             orario TIME NOT NULL,
                                             dottore_id VARCHAR(255) NOT NULL,
                                             prestazione_id VARCHAR(255) NOT NULL,
                                             FOREIGN KEY (dottore_id) REFERENCES dottore(id),
                                             FOREIGN KEY (prestazione_id) REFERENCES prestazione(id)
);

-- Table: prenotazione
CREATE TABLE IF NOT EXISTS prenotazione (
                                            id VARCHAR(255) NOT NULL PRIMARY KEY,
                                            utente_id VARCHAR(255) NOT NULL,
                                            disponibilita_id VARCHAR(255) NOT NULL,
                                            data DATE NOT NULL,
                                            FOREIGN KEY (utente_id) REFERENCES utente(id),
                                            FOREIGN KEY (disponibilita_id) REFERENCES disponibilita(id)
);

-- Table: esito
CREATE TABLE IF NOT EXISTS esito (
                                     id VARCHAR(255) NOT NULL PRIMARY KEY,
                                     descrizione TEXT,
                                     prescrizioni TEXT,
                                     prenotazione_id VARCHAR(255) NOT NULL,
                                     FOREIGN KEY (prenotazione_id) REFERENCES prenotazione(id)
);

-- Dati fittizi

-- Utenti
INSERT INTO utente (id, nome, email, telefono) VALUES
                                                   ('u1', 'Mario Rossi', 'mario.rossi@example.com', '3331112233'),
                                                   ('u2', 'Luca Bianchi', 'luca.bianchi@example.com', '3334445566');

-- Dottori
INSERT INTO dottore (id, nome, email, telefono) VALUES
                                                    ('d1', 'Dr. Verdi', 'verdi@clinic.it', '3351234567'),
                                                    ('d2', 'Dr. Neri', 'neri@clinic.it', '3369876543');

-- Prestazioni
INSERT INTO prestazione (id, nome, costo) VALUES
                                              ('p1', 'Visita Cardiologica', 100.0),
                                              ('p2', 'Controllo Dermatologico', 80.0);

-- Disponibilità
INSERT INTO disponibilita (id, giorno, orario, dottore_id, prestazione_id) VALUES
                                                                               ('disp1', '2025-05-10', '09:00:00', 'd1', 'p1'),
                                                                               ('disp2', '2025-05-11', '10:30:00', 'd2', 'p2'),
                                                                               ('disp3', '2025-05-12', '11:00:00', 'd1', 'p1');

-- Prenotazioni
INSERT INTO prenotazione (id, utente_id, disponibilita_id, data) VALUES
                                                                     ('pr1', 'u1', 'disp1', '2025-05-10'),
                                                                     ('pr2', 'u2', 'disp2', '2025-05-11');

-- Esiti
INSERT INTO esito (id, descrizione, prescrizioni, prenotazione_id) VALUES
                                                                       ('e1', 'Pressione nella norma.', 'Controllo tra 6 mesi.', 'pr1'),
                                                                       ('e2', 'Leggera irritazione. Applicare crema per 7 giorni.', 'Crema dermatologica X.', 'pr2');
