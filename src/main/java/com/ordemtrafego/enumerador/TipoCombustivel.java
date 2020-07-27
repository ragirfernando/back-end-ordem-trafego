package com.ordemtrafego.enumerador;

public enum TipoCombustivel {
    DIESEL("Diesel"),
    GASOLINA("Gasolina"),
    ALCOOL("Alcool"),
    FLEX("Flex");

    private final String nome;

    TipoCombustivel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
