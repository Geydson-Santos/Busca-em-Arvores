package com.jp.modelos;

public class Contador {

    private Conta arvoreAVL;
    private Conta arvoreBinaria;
    private Conta buscaBinaria;
    private String[] vetorDinamico;

    public Contador(Conta arvoreAVL, Conta arvoreBinaria, Conta buscaBinaria, String[] vetorDinamico) {
        this.arvoreAVL = arvoreAVL;
        this.arvoreBinaria = arvoreBinaria;
        this.buscaBinaria = buscaBinaria;
        this.vetorDinamico = vetorDinamico;
    }

    public Conta getArvoreAVL() {
        return arvoreAVL;
    }

    public Conta getArvoreBinaria() {
        return arvoreBinaria;
    }

    public Conta getBuscaBinaria() {
        return buscaBinaria;
    }

    public String[] getVetorDinamico() {
        return vetorDinamico;
    }
}
