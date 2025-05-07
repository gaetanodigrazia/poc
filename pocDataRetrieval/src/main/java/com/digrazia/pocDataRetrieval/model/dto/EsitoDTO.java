package com.digrazia.pocDataRetrieval.model.dto;

public class EsitoDTO {
    private String id;
    private String prenotazioneId;
    private String descrizione;
    private String prescrizioni;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenotazioneId() {
        return prenotazioneId;
    }

    public void setPrenotazioneId(String prenotazioneId) {
        this.prenotazioneId = prenotazioneId;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getPrescrizioni() {
        return prescrizioni;
    }

    public void setPrescrizioni(String prescrizioni) {
        this.prescrizioni = prescrizioni;
    }
}
