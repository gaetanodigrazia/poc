
package com.digrazia.pocDataRetrieval.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Prestazione {

    @Id
    private String id;

    private String nome;
    private Double costo;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }
}
