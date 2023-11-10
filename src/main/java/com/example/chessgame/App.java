package com.example.chessgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ChessGame");
        Image logo = new Image(String.valueOf(App.class.getResource("logo.png")));
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
        System.out.println("prova");


    }

    public static void main(String[] args) {
        launch(args);
    }
}
