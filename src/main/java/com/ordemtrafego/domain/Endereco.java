package com.ordemtrafego.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude={"cep", "logradouro", "complemento", "bairro", "localidade", "uf" , "numero"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String cep;

    @NotNull
    private String logradouro;

    @NotNull
    private String complemento;

    @NotNull
    private Integer numero;

    @NotNull
    private String bairro;

    @NotNull
    private String localidade;

    @NotNull
    private String uf;
}

