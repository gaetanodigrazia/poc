package com.digrazia.pocDataRetrieval.model.entity;


import jakarta.persistence.*;

@Entity
public class DottoreSede {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "dottore_id", nullable = false)
    private Dottore dottore;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;

    private boolean attivo;
    private String note;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Dottore getDottore() { return dottore; }
    public void setDottore(Dottore dottore) { this.dottore = dottore; }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }

    public boolean isAttivo() { return attivo; }
    public void setAttivo(boolean attivo) { this.attivo = attivo; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = java.util.UUID.randomUUID().toString();
        }
    }
}
