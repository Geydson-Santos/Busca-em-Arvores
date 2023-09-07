package com.jp.modelos;

public class Contador {

    private Conta arvoreAVL;
    private Conta arvoreBinaria;
    private Conta buscaBinaria;
    private Palavra[] vetorDinamico;

    public Contador(Conta arvoreAVL, Conta arvoreBinaria, Conta buscaBinaria, Palavra[] vetorDinamico) {
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

    public Palavra[] getVetorDinamico() {
        return vetorDinamico;
    }
}
