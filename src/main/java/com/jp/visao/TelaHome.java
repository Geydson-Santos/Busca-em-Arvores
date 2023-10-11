package com.jp.visao;

import com.jp.controle.Controle;
import com.jp.controle.IControle;
import com.jp.modelos.Contador;
import com.jp.modelos.Palavra;
import javafx.application.Platform;
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
    private Label labelArvoreBComparacoes;

    @FXML
    private Label labelArvoreBTempo;

    @FXML
    private Label labelCarregando;
    @FXML
    public Pane paneRoot;

    @FXML
    private Button btnArvore;
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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        contador = controle.arvorizar(arquivo.getAbsolutePath());


                        if (contador != null){


                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    labelArvoreBComparacoes.setText(contador.getArvoreB().getComparacoes() + "");
                                    labelArvoreBTempo.setText(contador.getArvoreB().getTempo());

                                    labelArvoreAVLComparacoes.setText(contador.getArvoreAVL().getComparacoes() + "");
                                    labelArvoreAVLTempo.setText(contador.getArvoreAVL().getTempo());

                                    labelArvoreBinariaComparacoes.setText(contador.getArvoreBinaria().getComparacoes() + "");
                                    labelArvoreBinariaTempo.setText(contador.getArvoreBinaria().getTempo());

                                    btnOcorrencias.setDisable(false);
                                    btnArvore.setDisable(false);
                                }
                            });
                        }else{
                            throw new Exception("Não foi possível processar o arquivo.");
                        }



                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                labelCarregando.setVisible(false);
                            }
                        });
                    }catch (Exception e) {
                        e.printStackTrace();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                PopupAlerta.setContentText(e.getMessage());
                                PopupAlerta.show();
                                labelCarregando.setVisible(false);
                                //setCarregandoVisible(false);
                            }
                        });
                    }
                }
            }).start();
        }
    }

    void nothing(){}

    @FXML
    void visualizarOcorrencias(ActionEvent event) {
        Run.telaPrincipal.setEditWindow("Ocorrência das Palavras", Run.app.getScene("TelaOcorrências.fxml"), (e) -> nothing());
    }

    @FXML
    void visualizarArvore(ActionEvent event) {
        Run.telaPrincipal.setEditWindow("Árvore", Run.app.getScene("TelaÁrvore.fxml"), (e) -> nothing());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Run.telaHome = this;
        PopupAlerta.setTitle("");
    }
}
