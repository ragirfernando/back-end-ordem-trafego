package com.ordemtrafego.domain;

import com.ordemtrafego.enumerador.StatusOrdemTrafego;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude={"origem", "destino", "veiculo", "condutor", "data" ,"hora" , "status", "distanciaPercorrer"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    @Temporal(TemporalType.TIME)
    private Date hora;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusOrdemTrafego status;

    @NotNull
    private Integer distanciaPercorrer;


}
