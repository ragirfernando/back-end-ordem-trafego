package com.ordemtrafego.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude={"nome", "cnh", "endereco", "cpf", "matricula"})
@NoArgsConstructor
@AllArgsConstructor
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
}
