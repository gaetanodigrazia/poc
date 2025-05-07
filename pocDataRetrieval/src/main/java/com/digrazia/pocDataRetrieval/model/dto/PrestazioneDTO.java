package com.digrazia.pocDataRetrieval.model.dto;

public class PrestazioneDTO {
    private String id;
    private String nome;
    private Double costo;

    public PrestazioneDTO() {}

    public PrestazioneDTO(String id, String nome, Double costo) {
        this.id = id;
        this.nome = nome;
        this.costo = costo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }
}
