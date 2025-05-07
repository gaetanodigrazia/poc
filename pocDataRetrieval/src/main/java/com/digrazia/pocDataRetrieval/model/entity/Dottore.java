
package com.digrazia.pocDataRetrieval.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Dottore {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "dottore")
    private List<DottoreSede> assegnazioni;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<DottoreSede> getAssegnazioni() {
        return assegnazioni;
    }

    public void setAssegnazioni(List<DottoreSede> assegnazioni) {
        this.assegnazioni = assegnazioni;
    }

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = java.util.UUID.randomUUID().toString();
        }
    }

}
