package com.ordemtrafego.domain;

import com.ordemtrafego.enumerador.CategoriaCNH;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude={"numeroCNH", "categoriaCNH", "validade"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cnh")
public class Cnh implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer numeroCNH;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoriaCNH categoriaCNH;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date validade;

}
