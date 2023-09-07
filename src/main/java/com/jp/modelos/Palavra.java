package com.jp.modelos;

public class Palavra {
    private final String palavra;
    private int ocorrencias = 0;

    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void incOcorrencias() {
        this.ocorrencias += 1;
    }
}
