package com.jp.visao;

import com.jp.modelos.Palavra;
import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.*;
//import java.util.


public class TelaOcorrências implements Initializable {

    @FXML
    private TableView<Palavra> TabelaOcorrencias;

    @FXML
    private TableColumn<?, ?> colunaOcorrencias;

    @FXML
    private TableColumn<?, ?> colunaPalavra;

    @FXML
    void extrairRelatorio(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Abrir arquivo de texto");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo de Texto", "*.txt"));
        File arquivo = fc.showSaveDialog(this.TabelaOcorrencias.getScene().getWindow());

        if(arquivo != null){
            try{
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw);

                for (Palavra palavra: TabelaOcorrencias.getItems()) {
                    bw.write(palavra.getPalavra() + "\t" + palavra.getOcorrencias() + "\n");
                }

                bw.close();
            }catch (Exception erro) {
                erro.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            colunaOcorrencias.setCellValueFactory(new PropertyValueFactory<>("ocorrencias"));
            colunaPalavra.setCellValueFactory(new PropertyValueFactory<>("palavra"));
            final ObservableList<Palavra> palavras = FXCollections.observableArrayList(Run.telaHome.contador.getVetorDinamico());
            TabelaOcorrencias.getItems().addAll(palavras);
        }catch (Exception e) {

        }
    }
}
