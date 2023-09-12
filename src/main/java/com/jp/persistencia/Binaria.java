package com.jp.persistencia;

import com.jp.modelos.Contador;
import com.jp.modelos.Palavra;

public class Binaria {
    
    private static String vetorPalavras[] = null;

    public static Contador buscaBinaria(String vetorDePalavras[]) {
        vetorPalavras = vetorDePalavras;
        
        Palavra palavras[] = new Palavra[1];
        
        for(String palavraString:vetorPalavras) {
            for(Palavra palavra:palavras) {
                if(palavra.getPalavra().equals(palavraString)) {
                    palavra.incOcorrencias();
                }else {
                    Palavra novoVetorPalavra[] = new Palavra[palavras.length+1];
                    for(int i = 0; i<palavras.length-1;i++) {
                        novoVetorPalavra[i] = palavras[i];
                    }
                   novoVetorPalavra[novoVetorPalavra.length-1] = new Palavra(palavraString);
                }
            }
        }
        
        return null;
    }   
}
