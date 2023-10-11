package com.jp.modelos;

import com.jp.persistencia.ArvoreB;
import com.jp.persistencia.ArvoreBalanceada;
import com.jp.persistencia.ArvoreDesbalanceada;

public class Contador {

    private Conta arvoreAVL;
    private Conta arvoreBinaria;
    private Conta buscaBinaria;

    private Conta arvoreB;
    private Palavra[] vetorDinamico;

    private ArvoreBalanceada avore;

    private ArvoreDesbalanceada avoreD;

    private ArvoreB avoreB;


    public Contador() {

    }

    public Contador(Conta arvoreAVL, Conta arvoreBinaria, Conta buscaBinaria, Palavra[] vetorDinamico) {
        this.arvoreAVL = arvoreAVL;
        this.arvoreBinaria = arvoreBinaria;
        this.buscaBinaria = buscaBinaria;
        this.vetorDinamico = vetorDinamico;
    }

    public ArvoreB getAvoreB() {
        return avoreB;
    }

    public void setAvoreB(ArvoreB avoreB) {
        this.avoreB = avoreB;
    }

    public Conta getArvoreB() {
        return arvoreB;
    }

    public void setArvoreB(Conta arvoreB) {
        this.arvoreB = arvoreB;
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

    public ArvoreDesbalanceada getAvoreD() {
        return avoreD;
    }

    public void setAvoreD(ArvoreDesbalanceada avoreD) {
        this.avoreD = avoreD;
    }
}
