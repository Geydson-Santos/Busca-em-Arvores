package com.jp.modelos;

public class QuickSort {

    public static Palavra[] quickSort(Palavra vetor[]){

        quickSort_Recursivo(vetor, 0, vetor.length-1);

        return vetor;
    }

    private static void quickSort_Recursivo(Palavra a[], int p, int u) {
        int i = p, f = u;                        // Extremos
        int x = (int) (Math.random()*(u-p+1))+p; // Aleatório
        Palavra pivô = a[x];                         // para evitar quadrático

        while (i <= f)  // Enquanto não se cruzarem
        {

            while (i < u && a[i].getPalavra().compareTo(pivô.getPalavra()) < 0) i++;      // Organiza primeira metade

            while (f > p && a[f].getPalavra().compareTo(pivô.getPalavra())> 0) f--;      // Organiza segunda metade

            if (i <= f) {                          // Se ainda não acabou
                Palavra aux = a[f];                            // troca os elementos
                a[f--] = a[i];                       // dos dois lados
                a[i++] = aux;                          // da lista
            }
        }

        if (p < f) quickSort_Recursivo(a,p,f);                // a[p]..a[f] < pivô
        if (i < u) quickSort_Recursivo(a,i,u);                // a[i]..a[u] > pivô


    }
}
