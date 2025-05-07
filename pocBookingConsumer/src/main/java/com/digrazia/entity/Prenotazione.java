
package com.digrazia.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Prenotazione {
    @Id
    private String id;
    private String utenteId;
    private String disponibilitaId;
    private String data;

    public Prenotazione() {
    }
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
