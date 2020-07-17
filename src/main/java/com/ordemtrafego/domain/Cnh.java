package com.ordemtrafego.domain;

import com.ordemtrafego.enumerador.CategoriaCNH;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "cnh")
public class Cnh implements Serializable {
    private static final long serialVersionUID = 1L;
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer numeroCNH;

    @Enumerated(EnumType.STRING)
    private CategoriaCNH categoriaCNH;

    @NotNull
    private String validade;

    public Cnh(Integer id) {
        this.id = id;
    }

    public Cnh() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(Integer numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public CategoriaCNH getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cnh cnh = (Cnh) o;

        return id != null ? id.equals(cnh.id) : cnh.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CNH{" +
                "id=" + id +
                ", numeroCNH=" + numeroCNH +
                ", categoriaCNH='" + categoriaCNH + '\'' +
                ", validade=" + validade +
                '}';
    }
}
