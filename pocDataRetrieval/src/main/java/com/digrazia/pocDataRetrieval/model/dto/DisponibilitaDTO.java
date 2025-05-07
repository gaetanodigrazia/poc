package com.digrazia.pocDataRetrieval.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DisponibilitaDTO {
    private String id;
    private LocalDate giorno;
    private LocalTime orario;
    private String dottoreId;
    private String prestazioneId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getGiorno() {
        return giorno;
    }

    public void setGiorno(LocalDate giorno) {
        this.giorno = giorno;
    }

    public LocalTime getOrario() {
        return orario;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }

    public String getDottoreId() {
        return dottoreId;
    }

    public void setDottoreId(String dottoreId) {
        this.dottoreId = dottoreId;
    }

    public String getPrestazioneId() {
        return prestazioneId;
    }

    public void setPrestazioneId(String prestazioneId) {
        this.prestazioneId = prestazioneId;
    }
}
