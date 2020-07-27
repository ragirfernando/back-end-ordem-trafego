package com.ordemtrafego.enumerador;

public enum StatusOrdemTrafego {
    ANDAMENTO("Andamento"),
    AGENDADA("Agendada"),
    FINALIZADA("Finalizada");

    private final String nome;

    StatusOrdemTrafego(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
