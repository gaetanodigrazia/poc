package com.digrazia.pocDataRetrieval.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Prenotazione {
    @Id
    private String id;
    private String utenteId;
    private String disponibilitaId;
    @Column
    private LocalDate data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUtenteId() {
        return utenteId;
    }

    public void setUtenteId(String utenteId) {
        this.utenteId = utenteId;
    }

    public String getDisponibilitaId() {
        return disponibilitaId;
    }

    public void setDisponibilitaId(String disponibilitaId) {
        this.disponibilitaId = disponibilitaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
