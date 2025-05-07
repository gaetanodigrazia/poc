package com.digrazia.pocDataRetrieval.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Disponibilita {

    @Id
    private String id;

    private LocalDate giorno;
    private LocalTime orario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dottore_id", nullable = false)
    private Dottore dottore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestazione_id", nullable = false)
    private Prestazione prestazione;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDate getGiorno() { return giorno; }
    public void setGiorno(LocalDate giorno) { this.giorno = giorno; }

    public LocalTime getOrario() { return orario; }
    public void setOrario(LocalTime orario) { this.orario = orario; }

    public Dottore getDottore() { return dottore; }
    public void setDottore(Dottore dottore) { this.dottore = dottore; }

    public Prestazione getPrestazione() { return prestazione; }
    public void setPrestazione(Prestazione prestazione) { this.prestazione = prestazione; }
}
