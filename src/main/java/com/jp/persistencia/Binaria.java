package com.jp.persistencia;

import com.jp.modelos.BuscaBinaria;
import com.jp.modelos.Contador;
import com.jp.modelos.Palavra;
import java.util.Arrays;

public class Binaria {
    
    private static String vetorPalavras[] = null;

    public static Contador buscaBinaria(String vetorDePalavras[]) {
        vetorPalavras = vetorDePalavras;
        
        Palavra palavras[] = new Palavra[1];
        palavras[0] = new Palavra(vetorDePalavras[0]);
        
        for(int j = 1; j < vetorDePalavras.length;j++) {
            String palavraString = vetorDePalavras[j];
            int posPalavraEncontrada = BuscaBinaria.binaria(palavras, palavraString, 0, palavras.length-1);
            boolean palavraIgual = posPalavraEncontrada != -1;

            if(palavraIgual){
                palavras[posPalavraEncontrada].incOcorrencias();
            }
            else{
                Palavra novoVetorPalavra[] = new Palavra[palavras.length+1];
                for(int i = 0; i<palavras.length-1;i++) {
                    novoVetorPalavra[i] = palavras[i];
                }
                novoVetorPalavra[novoVetorPalavra.length-1] = new Palavra(palavraString);
                palavras = novoVetorPalavra;

                palavras = (Palavra[]) Arrays.asList(palavras).stream().sorted((o1, o2) -> o1.getPalavra().compareTo(o2.getPalavra())).toArray();
            }
        }
        
        
        
        return null;
    }   
}
