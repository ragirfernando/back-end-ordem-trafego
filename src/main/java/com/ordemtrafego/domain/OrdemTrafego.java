package com.ordemtrafego.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ordemtrafego")
public class OrdemTrafego implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = {CascadeType.ALL} ,  orphanRemoval = true)
    @JoinColumn(name = "origem_id", referencedColumnName = "id")
    private Endereco origem;

    @OneToOne(cascade = {CascadeType.ALL} ,  orphanRemoval = true)
    @JoinColumn(name = "destino_id", referencedColumnName = "id")
    private Endereco destino;

    @NotNull
    @OneToOne
    private Veiculo veiculo;

    @NotNull
    @OneToOne
    private Condutor condutor;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;

    @NotNull
    private String status;

    @NotNull
    private Integer distanciaPercorrer;

    public OrdemTrafego() {
    }

    public OrdemTrafego(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getOrigem() {
        return origem;
    }

    public void setOrigem(Endereco origem) {
        this.origem = origem;
    }

    public Endereco getDestino() {
        return destino;
    }

    public void setDestino(Endereco destino) {
        this.destino = destino;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDistanciaPercorrer() {
        return distanciaPercorrer;
    }

    public void setDistanciaPercorrer(Integer distanciaPercorrer) {
        this.distanciaPercorrer = distanciaPercorrer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdemTrafego that = (OrdemTrafego) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrdemTrafego{" +
                "id=" + id +
                ", origem=" + origem +
                ", destino=" + destino +
                ", veiculo=" + veiculo +
                ", condutor=" + condutor +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", distanciaPercorrer=" + distanciaPercorrer +
                '}';
    }
}
