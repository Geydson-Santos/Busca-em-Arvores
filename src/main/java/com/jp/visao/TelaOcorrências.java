package com.jp.visao;

import com.jp.modelos.Palavra;
import com.sun.source.tree.TryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
