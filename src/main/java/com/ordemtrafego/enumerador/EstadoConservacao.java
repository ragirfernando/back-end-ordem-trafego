package com.ordemtrafego.enumerador;

public enum EstadoConservacao {
    NOVO("Novo"),
    SEMINOVO("SemiNovo"),
    USADO("Usado");

    private final  String nome;

    EstadoConservacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
