package com.ordemtrafego.domain;

import com.ordemtrafego.enumerador.CategoriaVeiculo;
import com.ordemtrafego.enumerador.EstadoConservacao;
import com.ordemtrafego.enumerador.TipoCombustivel;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private Integer km;

    @NotNull
    private String placa;

    @NotNull
    private String cor;

    @NotNull
    private int anoFabicacao;

    @Enumerated(EnumType.STRING)
    private CategoriaVeiculo categoriaVeiculo;

    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Enumerated(EnumType.STRING)
    private EstadoConservacao  estadoConservacao;

    public Veiculo(Integer id) {
        this.id = id;
    }

    public Veiculo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoFabicacao() {
        return anoFabicacao;
    }

    public void setAnoFabicacao(int anoFabicacao) {
        this.anoFabicacao = anoFabicacao;
    }

    public CategoriaVeiculo getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    public void setCategoriaVeiculo(CategoriaVeiculo categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public EstadoConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veiculo veiculo = (Veiculo) o;

        return id != null ? id.equals(veiculo.id) : veiculo.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", km=" + km +
                ", placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                ", anoFabicacao=" + anoFabicacao +
                ", categoriaVeiculo=" + categoriaVeiculo +
                ", tipoCombustivel=" + tipoCombustivel +
                ", estadoConservacao=" + estadoConservacao +
                '}';
    }
}
