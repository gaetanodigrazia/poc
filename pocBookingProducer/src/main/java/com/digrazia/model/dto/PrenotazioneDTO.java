package com.digrazia.model.dto;

public class PrenotazioneDTO {
    private String id;
    private String utenteId;
    private String disponibilitaId;
    private String data;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUtenteId() { return utenteId; }
    public void setUtenteId(String utenteId) { this.utenteId = utenteId; }

    public String getDisponibilitaId() { return disponibilitaId; }
    public void setDisponibilitaId(String disponibilitaId) { this.disponibilitaId = disponibilitaId; }

    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}
