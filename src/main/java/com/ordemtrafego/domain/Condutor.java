package com.ordemtrafego.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Condutor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @OneToOne(cascade = {CascadeType.ALL},  orphanRemoval = true)
    @JoinColumn(name = "cnh_id", referencedColumnName = "id")
    private Cnh cnh;

    @OneToOne(cascade = {CascadeType.ALL} ,  orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @NotNull
    private String cpf;

    @NotNull
    private String matricula;

    public Condutor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cnh getCnh() {
        return cnh;
    }

    public void setCnh(Cnh cnh) {
        this.cnh = cnh;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condutor condutor = (Condutor) o;

        return id != null ? id.equals(condutor.id) : condutor.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Condutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnh=" + cnh +
                ", endereco=" + endereco +
                ", cpf='" + cpf + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
