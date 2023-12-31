package com.example.ws12;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    protected void onStartMoved(Event event){
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: green" );
    }

    @FXML
    protected void onStartExited(Event event){
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: white" );
    }

    @FXML
    protected void onExitMoved(Event event){
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: red" );
    }

    @FXML
    protected void onExitExited(Event event){
        Button button = (Button) event.getSource();
        button.setStyle("-fx-background-color: white" );
    }

    @FXML
    public void click0nStart(Event event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = null;
        if(root != null) {
            scene = new Scene(root);
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onExitButtonClick(Event event) {
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
}