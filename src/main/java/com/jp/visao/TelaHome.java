package com.jp.visao;

import com.jp.controle.Controle;
import com.jp.controle.IControle;
import com.jp.modelos.Contador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaHome implements Initializable {


    @FXML
    public Pane paneRoot;

    IControle controle = new Controle();

    @FXML
    void abrirArquivo(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Abrir arquivo de texto");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo de Texto", "*.txt"));
        File arquivo = fc.showOpenDialog(this.paneRoot.getScene().getWindow());

        if (arquivo != null){
            try {
                Contador contador = controle.arvorizar(arquivo.getAbsolutePath());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Run.telaHome = this;
    }
}
