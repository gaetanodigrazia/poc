package com.digrazia.pocDataRetrieval.model.dto;
import java.util.Objects;

public class DottoreDTO {
    private String id;
    private String nome;
    private String email;
    private String telefono;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DottoreDTO dottore = (DottoreDTO) o;
        return Objects.equals(id, dottore.id) && Objects.equals(nome, dottore.nome) && Objects.equals(email, dottore.email) && Objects.equals(telefono, dottore.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, telefono);
    }

    @Override
    public String toString() {
        return "Dottore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
