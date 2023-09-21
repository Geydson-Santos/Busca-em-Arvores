package com.jp.visao;

import com.jp.modelos.Contador;
import com.jp.modelos.Palavra;
import com.jp.persistencia.ArvoreBalanceada;
import com.jp.persistencia.ArvoreDesbalanceada;
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

    public void criarArvore(ArvoreBalanceada.Node node, TreeItem item){
        if (node.left != null){
            TreeItem itemLeft = new TreeItem(node.left.key);
            item.getChildren().add(itemLeft);

            criarArvore(node.left, itemLeft);
        }
        if (node.right != null){
            TreeItem itemRight = new TreeItem(node.right.key);
            item.getChildren().add(itemRight);

            criarArvore(node.right, itemRight);
        }
    }

    public void criarArvoreD(ArvoreDesbalanceada.Node node, TreeItem item){
        if (node.left != null){
            TreeItem itemLeft = new TreeItem(node.left.key);
            item.getChildren().add(itemLeft);

            criarArvoreD(node.left, itemLeft);
        }
        if (node.right != null){
            TreeItem itemRight = new TreeItem(node.right.key);
            item.getChildren().add(itemRight);

            criarArvoreD(node.right, itemRight);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Contador contador = Run.telaHome.contador;

            ArvoreBalanceada.Node raiz = contador.getAvore().getRoot();

            TreeItem itemRaiz = new TreeItem(raiz.key);

            viewArvore.setRoot(itemRaiz);

            criarArvore(raiz, itemRaiz);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
