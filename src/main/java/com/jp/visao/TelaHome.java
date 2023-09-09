package com.jp.visao;

import com.jp.controle.Controle;
import com.jp.controle.IControle;
import com.jp.modelos.Contador;
import com.jp.modelos.Palavra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaHome implements Initializable {

    @FXML
    private Button btnOcorrencias;

    @FXML
    private Label labelArvoreAVLComparacoes;

    @FXML
    private Label labelArvoreAVLTempo;

    @FXML
    private Label labelArvoreBinariaComparacoes;

    @FXML
    private Label labelArvoreBinariaTempo;

    @FXML
    private Label labelBuscaBinariaComparacoes;

    @FXML
    private Label labelBuscaBinariaTempo;

    @FXML
    private Label labelCarregando;
    @FXML
    public Pane paneRoot;

    IControle controle = new Controle();

    public Contador contador =  null
            //new Contador(null, null, null, new Palavra[]{new Palavra("ola"), new Palavra("tudo"), new Palavra("bem")})
            ;

    Alert PopupAlerta = new Alert(Alert.AlertType.ERROR);

    @FXML
    void abrirArquivo(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Abrir arquivo de texto");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo de Texto", "*.txt"));
        File arquivo = fc.showOpenDialog(this.paneRoot.getScene().getWindow());

        if (arquivo != null){
            labelCarregando.setVisible(true);
            new Thread(() -> {
                try {
                        contador = controle.arvorizar(arquivo.getAbsolutePath());

                        if (contador != null){
                            labelBuscaBinariaComparacoes.setText(contador.getBuscaBinaria().getComparacoes() + "");
                            labelBuscaBinariaTempo.setText(contador.getBuscaBinaria().getTempo());

                            labelArvoreAVLComparacoes.setText(contador.getArvoreAVL().getComparacoes() + "");
                            labelArvoreAVLTempo.setText(contador.getArvoreAVL().getTempo());

                            labelArvoreBinariaComparacoes.setText(contador.getArvoreBinaria().getComparacoes() + "");
                            labelArvoreBinariaTempo.setText(contador.getArvoreBinaria().getTempo());

                            btnOcorrencias.setDisable(false);
                        }else{
                            throw new Exception("Não foi possível processar o arquivo.");
                        }

                        labelCarregando.setVisible(false);
                }catch (Exception e) {
                    e.printStackTrace();
                    PopupAlerta.setContentText(e.getMessage());
                    PopupAlerta.show();
                    labelCarregando.setVisible(false);
                    //setCarregandoVisible(false);
                }
            }).run();
        }
    }

    void nothing(){}

    @FXML
    void visualizarOcorrencias(ActionEvent event) {
        Run.telaPrincipal.setEditWindow("Ocorrência das Palavras", Run.app.getScene("TelaOcorrências.fxml"), (e) -> nothing());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Run.telaHome = this;
        PopupAlerta.setTitle("");
    }
}
