package com.example.chessgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu {

    private Parent root;
    private Scene scena;
    private Stage stage;


    @FXML
    private Button btn_esci;

    @FXML
    private Button btn_impostazioni;

    @FXML
    private Button btn_nuovapartita;

    @FXML
    private Button btn_uniscitipartita;

    @FXML
    void btn_esciClicked(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btn_impostazioniClicked(ActionEvent event) {
        //TODO
        //Aggiungere apertura finestra con impostazioni del gioco
    }

    @FXML
    void btn_nuovapartitaClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ControllerMenu.class.getResource("HostScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scena = new Scene(fxmlLoader.load());
        stage.setScene(scena);
        stage.show();
    }

    @FXML
    void btn_uniscitipartitaClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ControllerMenu.class.getResource("ClientScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scena = new Scene(fxmlLoader.load());
        stage.setScene(scena);
        stage.show();
    }

}