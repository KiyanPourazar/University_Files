package com.example.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class HelloController {
    @FXML
    private TextField textField;

    @FXML
    protected void keySet(KeyEvent event){
        String finalText = event.getText();
        String text = textField.getText();
        String temp = text + finalText;
        textField.setText(temp);
    }

    @FXML
    protected void setInt(ActionEvent event) {
        if(textField.getText().equals("0.0")){
            textField.setText("");
        }
        Button button = (Button) event.getSource();
        String finalText = button.getText();
        String text = textField.getText();
        String temp = text + finalText;
        textField.setText(temp);
    }
    @FXML
    protected void AC(){
        String finalText = "0.0";
        textField.setText(finalText);
    }

    @FXML
    protected void dot(){
        String finalText = textField.getText() + ".";
        textField.setText(finalText);
    }

    @FXML
    protected void add(){
        String finalText = textField.getText() + "+";
        textField.setText(finalText);
    }

    @FXML
    protected void sub(){
        String finalText = textField.getText() + "-";
        textField.setText(finalText);
    }

    @FXML
    protected void multiply(){
        String finalText = textField.getText() + "*";
        textField.setText(finalText);
    }

    @FXML
    protected void divide(){
        String finalText = textField.getText() + "/";
        textField.setText(finalText);
    }

    @FXML
    protected void calc(){
       String temp = textField.getText();
       String[] holder = temp.split("[+*/-]");
       double a = Double.parseDouble(holder[0]);
       double b = Double.parseDouble(holder[1]);
       double res =0;
       if(temp.contains("+")){
           res = a + b;
       }
       else if(temp.contains("-")){
           res = a - b;
       }
       else if(temp.contains("*")){
           res = a*b;
       }
       else {
          if(b == 0){
              System.out.println("can not divide by zero!");
              textField.setText("INF");
          }
          else {
              res = a / b ;
          }
       }
       textField.setText(String.valueOf(res));
    }
}