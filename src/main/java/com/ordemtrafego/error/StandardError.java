package com.ordemtrafego.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVerionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-BR", timezone = "Brazil/East")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
