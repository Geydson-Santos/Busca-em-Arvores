package com.jp.modelos;

import com.jp.persistencia.ArvoreBalanceada;
import com.jp.persistencia.ArvoreDesbalanceada;

public class Contador {

    private Conta arvoreAVL;
    private Conta arvoreBinaria;
    private Conta buscaBinaria;
    private Palavra[] vetorDinamico;

    private ArvoreBalanceada avore;

    private ArvoreDesbalanceada avoreD;


    public Contador() {

    }

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

    public void setArvoreAVL(Conta arvoreAVL) {
        this.arvoreAVL = arvoreAVL;
    }

    public void setArvoreBinaria(Conta arvoreBinaria) {
        this.arvoreBinaria = arvoreBinaria;
    }

    public void setBuscaBinaria(Conta buscaBinaria) {
        this.buscaBinaria = buscaBinaria;
    }

    public void setVetorDinamico(Palavra[] vetorDinamico) {
        this.vetorDinamico = vetorDinamico;
    }

    public ArvoreBalanceada getAvore() {
        return avore;
    }

    public void setAvore(ArvoreBalanceada avore) {
        this.avore = avore;
    }

    public ArvoreDesbalanceada getAvoreD(ArvoreDesbalanceada AD) {
        return avoreD;
    }

    public void setAvoreD(ArvoreDesbalanceada avoreD) {
        this.avoreD = avoreD;
    }
}
