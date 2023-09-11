package com.jp.controle;

import com.jp.modelos.Contador;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controle implements IControle{
    @Override
    public Contador arvorizar(String caminhoDoTXT) throws Exception {
        String texto = limpaTexto(caminhoDoTXT);
        texto = retiraStop(texto);

        return null;
    }

    private String limpaTexto(String caminhoDoTXT) throws FileNotFoundException {
        String textoBruto = new Scanner(new File(caminhoDoTXT), "UTF-8").useDelimiter("\\A").next();
        while(textoBruto.contains("  ")) {
            textoBruto = textoBruto.replace("  ", " ");
            textoBruto = textoBruto.replace(System.lineSeparator(), " ");
        }
        String textoLimpo = textoBruto = textoBruto.trim();
        return textoLimpo;
    }

    private String retiraStop(String textoBruto) throws Exception{
        String[] StopWords = new Scanner(new File("../Stopwords/stopwords.txt"), "UTF-8").useDelimiter("\\A").next().split(System.lineSeparator());
        for (String palavra :
                StopWords) {
            textoBruto.replace(palavra, "");
        }
        System.out.println(textoBruto);
        return textoBruto;
    }
}
