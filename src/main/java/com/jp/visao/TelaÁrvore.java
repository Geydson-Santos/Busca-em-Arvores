package com.jp.visao;

import com.jp.modelos.Palavra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
//import java.util.


public class TelaÁrvore implements Initializable {

    @FXML
    private TreeView viewArvore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TreeItem item1 = new TreeItem(new Palavra("Teste1"));
            TreeItem item2 = new TreeItem(new Palavra("Teste2"));
            TreeItem item3 = new TreeItem(new Palavra("Teste3"));
            viewArvore.setRoot(item1);
            item1.getChildren().addAll(item2, item3);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
