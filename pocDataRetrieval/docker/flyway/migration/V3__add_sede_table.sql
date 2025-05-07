USE poc;

CREATE TABLE sede (
                      id VARCHAR(255) NOT NULL PRIMARY KEY,
                      nome VARCHAR(255),
                      citta VARCHAR(255),
                      indirizzo VARCHAR(255)
);

INSERT INTO sede (id, nome, citta, indirizzo) VALUES
                                                  ('s1', 'Centro Milano', 'Milano', 'Via Verdi 10'),
                                                  ('s2', 'Clinica Roma', 'Roma', 'Piazza Italia 5'),
                                                  ('s3', 'Poliambulatorio Kalsa', 'Palermo', 'Via Alloro 21'),
                                                  ('s4', 'Centro Medico Libertà', 'Palermo', 'Via Libertà 135'),
                                                  ('s5', 'Clinica San Lorenzo', 'Palermo', 'Via San Lorenzo 54'),
                                                  ('s6', 'Ambulatorio Bagheria', 'Bagheria', 'Corso Umberto I 89'),
                                                  ('s7', 'Studio Medico Villabate', 'Villabate', 'Via G. Meli 22');

CREATE TABLE dottore_sede (
                              id VARCHAR(255) NOT NULL PRIMARY KEY,
                              dottore_id VARCHAR(255) NOT NULL,
                              sede_id VARCHAR(255) NOT NULL,
                              attivo BOOLEAN DEFAULT TRUE,
                              note TEXT,

                              CONSTRAINT fk_dottore FOREIGN KEY (dottore_id) REFERENCES dottore(id),
                              CONSTRAINT fk_sede FOREIGN KEY (sede_id) REFERENCES sede(id)
);


INSERT INTO dottore (id, nome, email, telefono) VALUES
                                                    ('d3', 'Dr. Giuseppe Verdi', 'g.verdi@example.com', '3333456789'),
                                                    ('d4', 'Dr.ssa Angela Neri', 'a.neri@example.com', '3334567890'),
                                                    ('d5', 'Dr. Fabio Conte', 'f.conte@example.com', '3335678901'),
                                                    ('d6', 'Dr. Luca Romano', 'l.romano@example.com', '3336789012'),
                                                    ('d7', 'Dr.ssa Elisa Greco', 'e.greco@example.com', '3337890123'),
                                                    ('d8', 'Dr. Antonio Sanna', 'a.sanna@example.com', '3338901234'),
                                                    ('d9', 'Dr.ssa Chiara Vitale', 'c.vitale@example.com', '3339012345'),
                                                    ('d10', 'Dr. Paolo Esposito', 'p.esposito@example.com', '3340123456'),
                                                    ('d11', 'Dr. Mario Rossi', 'm.rossi@example.com', '3331234567'),
                                                    ('d12', 'Dr.ssa Laura Bianchi', 'l.bianchi@example.com', '3332345678');


INSERT INTO dottore_sede (id, dottore_id, sede_id, attivo, note) VALUES
                                                                     ('ds1', 'd1', 's3', TRUE, 'Turno mattina'),
                                                                     ('ds2', 'd2', 's4', TRUE, 'Turno pomeridiano'),
                                                                     ('ds3', 'd3', 's5', TRUE, ''),
                                                                     ('ds4', 'd4', 's6', TRUE, 'Disponibile solo il mercoledì'),
                                                                     ('ds5', 'd5', 's7', FALSE, 'In pausa'),
                                                                     ('ds6', 'd1', 's4', TRUE, 'Turnazione extra'),
                                                                     ('ds7', 'd6', 's3', TRUE, ''),
                                                                     ('ds8', 'd7', 's4', TRUE, ''),
                                                                     ('ds9', 'd8', 's5', TRUE, ''),
                                                                     ('ds10', 'd9', 's6', TRUE, ''),
                                                                     ('ds11', 'd10', 's7', TRUE, '');
