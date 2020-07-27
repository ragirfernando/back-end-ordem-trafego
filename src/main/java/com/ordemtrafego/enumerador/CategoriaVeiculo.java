package com.ordemtrafego.enumerador;

public enum CategoriaVeiculo {
    PASSEIO("Passeio"),
    SUV("Suv"),
    CAMINHONETE("Caminhonete"),
    ONIBUS("Onibus"),
    VAN("Van"),
    CAMINHAO("Caminhção");

    private final String name;

    CategoriaVeiculo(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
