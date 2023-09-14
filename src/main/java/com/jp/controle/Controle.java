package com.jp.controle;
import com.jp.modelos.Conta;
import com.jp.persistencia.*;
import com.jp.modelos.Contador;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controle implements IControle{
    @Override
    public Contador arvorizar(String caminhoDoTXT) throws Exception {
        String texto = limpaTexto(caminhoDoTXT);
        texto = retiraStop(texto);
        String[] textoSeparado = texto.split(" ");
        for (String teste :
                textoSeparado) {
            //System.out.print(teste + "|");

        }
        Contador resposta = Binaria.buscaBinaria(textoSeparado);
        ArvoreBalanceada AB = new ArvoreBalanceada();
        ArvoreDesbalanceada AD = new ArvoreDesbalanceada();
        resposta.setArvoreAVL(AB.executarCodigo(textoSeparado));
        resposta.setArvoreBinaria(AD.executarCodigo(textoSeparado));
        return resposta;
    }

    private String limpaTexto(String caminhoDoTXT) throws FileNotFoundException {
        String textoBruto = new Scanner(new File(caminhoDoTXT), "UTF-8").useDelimiter("\\A").next();

        char[] letras = textoBruto.toCharArray();

        textoBruto = "";

        for(int i = 0; i < letras.length; i++){
            if (Character.isAlphabetic(letras[i]) || Character.isDigit(letras[i])) textoBruto += letras[i];
            else textoBruto += " ";
        }

        String normalizer = Normalizer.normalize(textoBruto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("[^\\p{ASCII}]");
        textoBruto = pattern.matcher(normalizer).replaceAll("");

        //textoBruto = textoBruto.replaceAll("[^a-z\\s]", " ");
        textoBruto = textoBruto.replaceAll(System.lineSeparator(), " ");
        while(textoBruto.contains("  ")) {
            textoBruto = textoBruto.replace("  ", " ");
        }
        String textoLimpo = textoBruto.trim();
        textoLimpo = textoLimpo.toLowerCase();
        //System.out.println(textoLimpo);
        return textoLimpo;
    }

    private String retiraStop(String textoBruto) throws Exception{
        textoBruto = " " + textoBruto + " ";
        String[] StopWords = new Scanner(new File(getClass().getResource("../arquivos/stopwords.txt").getFile()), "UTF-8").useDelimiter("\\A").next().split(" \n");
        for (String palavra :
                StopWords) {
            textoBruto = textoBruto.replace(" "+ palavra + " ", " ");
        }
        textoBruto = textoBruto.trim();
        return textoBruto;
    }

    public  static String senhorDoTempo(long tempoFinal){
        String tempoAtual = "Nanosegundos";
        if(tempoFinal > 10000000){
            tempoFinal = tempoFinal/1000000;
            tempoAtual = "Milisegundos";
            if(tempoFinal > 10000){
                tempoFinal = tempoFinal/1000;
                tempoAtual = "Segundos";
            }
        }
        return tempoFinal+" " + tempoAtual;
    }
}
