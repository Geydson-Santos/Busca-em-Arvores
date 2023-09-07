package com.jp.modelos;

public class Conta {

    private int comparacoes = 0;
    private final String tempo;

    public Conta(int comparacoes, String tempo) {
        this.comparacoes = comparacoes;
        this.tempo = tempo;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public String getTempo() {
        return tempo;
    }
}
