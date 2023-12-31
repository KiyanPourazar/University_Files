package com.example.ws12;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.util.Random;

public class gameController {
    @FXML
    Label notice;
    @FXML
    Label timer;
    @FXML
    GridPane gridPane;
    @FXML
    Label l00;
    @FXML
    Label l01;
    @FXML
    Label l02;
    @FXML
    Label l10;
    @FXML
    Label l11;
    @FXML
    Label l12;
    @FXML
    Label l20;
    @FXML
    Label l21;
    @FXML
    Label l22;


    public static char[][] gameBoard = new char[3][3];
    int remainedTime;
    boolean started = false;
    boolean done = false;
    int turn = 0;
    int fullPlaces = 0;

    @FXML
    public void clickOnStart(){
        if(!started && !done) {
            Logic.resetBoard(gameBoard);
            updateArray();
            started = true;
            done = false;
            timer.setVisible(true);
            timer.setText("1:00");
            remainedTime = 60;
            Thread threadTask = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (remainedTime > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        remainedTime--;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (remainedTime >= 10) {
                                    timer.setText("0:" + remainedTime);
                                } else {
                                    timer.setText("0:0" + remainedTime);
                                }
                                if (remainedTime == 0) {
                                    done = true;
                                }
                            }
                        });
                    }
                }
            });
            threadTask.start();
        }
        else if(started && !done){
            notice.setText("the game is in progress");
            Thread threadTask = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            notice.setText("");
                        }
                    });
                }
            });
            threadTask.start();
        }
        else if(done){
            notice.setText("");
            started = false;
            done = false;
            updateScene();
            turn = 0;
            fullPlaces = 0;
            clickOnStart();
        }
    }

    @FXML
    public void clickOnBoard(Event event){
        if(started && !done && turn==0){
            Label label = (Label) event.getSource();
            if(label.getText().length() != 0){
                notice.setText("this place is already given");
                Thread threadTask = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                notice.setText("");
                            }
                        });
                    }
                });
                threadTask.start();
            }
            else {
                label.setText("X");
                turn = 1;
                updateArray();
                if(Logic.isWon('X' , gameBoard)){
                    done = true;
                    notice.setText("you won");
                    remainedTime = 1;
                    timer.setVisible(false);
                }
                fullPlaces++;
                if (!done && fullPlaces<9) {
                    Thread threadTask = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Random random = new Random();
                                    int index = random.nextInt(9);
                                    int temp = Logic.botPlay(gameBoard);
                                    if(temp != -1){
                                        index = temp;
                                    }
                                    Label rand = (Label) gridPane.getChildren().get(index);
                                    while (rand.getText().length() != 0) {
                                        index = random.nextInt(9);
                                        rand = (Label) gridPane.getChildren().get(index);
                                    }
                                    rand.setText("O");
                                    turn = 0;
                                    updateArray();
                                    if(Logic.isWon('O' , gameBoard)){
                                        done = true;
                                        notice.setText("bot won");
                                        remainedTime = 1;
                                        timer.setVisible(false);
                                    }
                                    fullPlaces++;
                                }
                            });
                        }
                    });
                    threadTask.start();
                }
                if(fullPlaces == 9 && !Logic.isWon('X' , gameBoard) && !Logic.isWon('O' , gameBoard)){
                    done = true;
                    notice.setText("draw");
                    remainedTime = 1;
                }
            }
        }
    }


    @FXML
    public void clickOnMenu(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
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

    public void updateArray(){
        gameBoard[0][0] = l00.getText().length()>0 ? l00.getText().charAt(0) : '0';
        gameBoard[0][1] = l01.getText().length()>0 ? l01.getText().charAt(0) : '0';
        gameBoard[0][2] = l02.getText().length()>0 ? l02.getText().charAt(0) : '0';
        gameBoard[1][0] = l10.getText().length()>0 ? l10.getText().charAt(0) : '0';
        gameBoard[1][1] = l11.getText().length()>0 ? l11.getText().charAt(0) : '0';
        gameBoard[1][2] = l12.getText().length()>0 ? l12.getText().charAt(0) : '0';
        gameBoard[2][0] = l20.getText().length()>0 ? l20.getText().charAt(0) : '0';
        gameBoard[2][1] = l21.getText().length()>0 ? l21.getText().charAt(0) : '0';
        gameBoard[2][2] = l22.getText().length()>0 ? l22.getText().charAt(0) : '0';
    }

    public void updateScene(){
        l00.setText("");
        l01.setText("");
        l02.setText("");
        l10.setText("");
        l11.setText("");
        l12.setText("");
        l20.setText("");
        l21.setText("");
        l22.setText("");
    }
}