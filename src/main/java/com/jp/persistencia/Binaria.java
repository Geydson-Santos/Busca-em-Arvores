package com.jp.persistencia;

import com.jp.controle.Controle;
import com.jp.modelos.*;

import java.util.Arrays;

public class Binaria {

    private static int comparacoes = 0;

    public static void incComparacoes(){comparacoes += 1;}

    public static Contador buscaBinaria(String vetorDePalavras[]) {
        comparacoes = 0;
        long tempoInicial = System.nanoTime();
        
        Palavra palavras[] = new Palavra[0];
        
        for(int j = 0; j < vetorDePalavras.length;j++) {
            //System.out.println("processando palavra");
            String palavraString = vetorDePalavras[j];
            int posPalavraEncontrada = BuscaBinaria.binaria(palavras, palavraString, 0, palavras.length-1);
            boolean palavraIgual = posPalavraEncontrada != -1;

            if(palavraIgual){
                palavras[posPalavraEncontrada].incOcorrencias();
            }
            else{
                Palavra novoVetorPalavra[] = new Palavra[palavras.length+1];
                for(int i = 0; i<palavras.length;i++) {
                    novoVetorPalavra[i] = palavras[i];
                }
                novoVetorPalavra[novoVetorPalavra.length-1] = new Palavra(palavraString);
                palavras = novoVetorPalavra;
                palavras = QuickSort.quickSort(palavras);
            }
        }
        
        Contador contador = new Contador();

        contador.setVetorDinamico(palavras);

        long tempoFinal = System.nanoTime();

        long tempoTotal = tempoFinal - tempoInicial;

        contador.setBuscaBinaria(new Conta(comparacoes, Controle.senhorDoTempo(tempoTotal)));
        
        return contador;
    }   
}
