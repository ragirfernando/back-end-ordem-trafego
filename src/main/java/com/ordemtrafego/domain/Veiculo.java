package com.ordemtrafego.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ordemtrafego.enumerador.CategoriaVeiculo;
import com.ordemtrafego.enumerador.EstadoConservacao;
import com.ordemtrafego.enumerador.TipoCombustivel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude={"marca", "modelo", "kmRodados", "placa", "cor", "anoFabicacao" , "categoriaVeiculo", "tipoCombustivel", "estadoConservacao"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    private Integer kmRodados;

    @NotNull
    private String placa;

    @NotNull
    private String cor;

    @NotNull
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Integer anoFabricacao;

    @Enumerated(EnumType.STRING)
    private CategoriaVeiculo categoriaVeiculo;

    @Enumerated(EnumType.STRING)
    private TipoCombustivel tipoCombustivel;

    @Enumerated(EnumType.STRING)
    private EstadoConservacao  estadoConservacao;


}
