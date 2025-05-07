package com.digrazia.pocDataRetrieval.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Sede {
    @Id
    private String id;
    private String nome;
    private String citta;
    private String indirizzo;
    @OneToMany(mappedBy = "sede")
    private List<DottoreSede> assegnazioni;

}
