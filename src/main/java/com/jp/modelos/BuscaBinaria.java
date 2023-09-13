package com.jp.modelos;

import com.jp.persistencia.Binaria;

public class BuscaBinaria {

    public static int binaria(Palavra vetor[], String palavra, int inicio, int fim){
        Binaria.incComparacoes();
        if(inicio > fim) return -1;

        int meio = (inicio + fim)/2;

        Binaria.incComparacoes();
        if(vetor[meio].getPalavra().equals(palavra)) return meio;

        Binaria.incComparacoes();
        if(palavra.compareTo(vetor[meio].getPalavra()) < 0) return binaria(vetor, palavra, inicio, meio - 1);

        /*Binaria.incComparacoes();
        if(palavra.length() == vetor[meio].getPalavra().length()){
            int cont = 1;

            try {
                while(vetor[meio - cont].getPalavra().length() == palavra.length() && !vetor[meio - cont].getPalavra().equals(palavra)){
                    cont++;
                }
            } catch (Exception e) {}

            if(vetor[meio - cont].equals(palavra)) return meio - cont;

            cont = 1;

            try {
                while(vetor[meio + cont].getPalavra().length() == palavra.length() && !vetor[meio + cont].getPalavra().equals(palavra)){
                    cont++;
                }
            } catch (Exception e) {}

            if(vetor[meio + cont].getPalavra().equals(palavra)) return meio + cont;

            return -1;
        }*/

        return binaria(vetor, palavra, meio + 1, fim);
    }
}
