package com.digrazia.pocDataRetrieval.model.dto;


import java.time.LocalDate;

public class PrenotazioneDTO {
    private String id;
    private String utenteId;
    private String disponibilitaId;
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
