package com.example.ws12;

public class Logic {
    public static void resetBoard(char[][] gameBoard){
        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<3 ; j++) {
                gameBoard[i][j] = '0';
            }
        }
    }

    public static boolean isWon(char ch , char[][] gameBoard){
        for (int i=0 ; i<3 ; i++) {
            if(gameBoard[i][0] == ch && gameBoard[i][1] == ch && gameBoard[i][2] == ch){
                return true;
            }
            if(gameBoard[0][i] == ch && gameBoard[1][i] == ch && gameBoard[2][i] == ch){
                return true;
            }
        }
        if(gameBoard[0][0] == ch && gameBoard[1][1] == ch && gameBoard[2][2] == ch){
            return true;
        }
        if(gameBoard[2][0] == ch && gameBoard[1][1] == ch && gameBoard[0][2] == ch){
            return true;
        }
        return false;
    }
    
    public static int botPlay(char[][] gameBoard){
        char x = 'X';
        char o = 'O';
        if(gameBoard[0][0] == x && gameBoard[0][1] == x){
            if(gameBoard[0][2] != o){
                return 2;
            }
        }
        if(gameBoard[1][0] == x && gameBoard[1][1] == x) {
            if(gameBoard[1][2] != o){
                return 5;
            }
        }
        if(gameBoard[2][0] == x && gameBoard[2][1] == x) {
            if(gameBoard[2][2] != o){
                return 8;
            }
        }
        if(gameBoard[0][0] == x && gameBoard[1][0] == x) {
            if(gameBoard[2][0] != o){
                return 6;
            }
        }
        if(gameBoard[0][1] == x && gameBoard[1][1] == x) {
            if(gameBoard[2][1] != o){
                return 7;
            }
        }
        if(gameBoard[0][2] == x && gameBoard[1][2] == x) {
            if(gameBoard[2][2] != o){
                return 8;
            }
        }
        if(gameBoard[0][0] == x && gameBoard[1][1] == x) {
            if(gameBoard[2][2] != o){
                return 8;
            }
        }
        if(gameBoard[0][2] == x && gameBoard[1][1] == x) {
            if(gameBoard[2][0] != o){
                return 6;
            }
        }
        if(gameBoard[0][2] == x && gameBoard[2][2] == x) {
            if(gameBoard[1][2] != o){
                return 5;
            }
        }
        if(gameBoard[0][1] == x && gameBoard[2][1] == x) {
            if(gameBoard[1][1] != o){
                return 4;
            }
        }
        if(gameBoard[0][0] == x && gameBoard[2][0] == x) {
            if(gameBoard[1][0] != o){
                return 3;
            }
        }
        if(gameBoard[0][0] == x && gameBoard[0][2] == x) {
            if(gameBoard[0][1] != o){
                return 1;
            }
        }
        if(gameBoard[1][0] == x && gameBoard[1][2] == x) {
            if(gameBoard[1][1] != o){
                return 4;
            }
        }
        if(gameBoard[2][0] == x && gameBoard[2][2] == x) {
            if(gameBoard[2][1] != o){
                return 7;
            }
        }
        if(gameBoard[0][0] == x && gameBoard[2][2] == x) {
            if(gameBoard[1][1] != o){
                return 4;
            }
        }
        if(gameBoard[2][0] == x && gameBoard[0][2] == x) {
            if(gameBoard[1][1] != o){
                return 4;
            }
        }
        if(gameBoard[2][2] == x && gameBoard[1][2] == x) {
            if(gameBoard[0][2] != o){
                return 2;
            }
        }
        if(gameBoard[2][1] == x && gameBoard[1][1] == x) {
            if(gameBoard[0][1] != o){
                return 1;
            }
        }
        if(gameBoard[2][0] == x && gameBoard[1][0] == x) {
            if(gameBoard[0][0] != o){
                return 0;
            }
        }
        if(gameBoard[0][1] == x && gameBoard[0][2] == x) {
            if(gameBoard[0][0] != o){
                return 0;
            }
        }
        if(gameBoard[1][1] == x && gameBoard[1][2] == x) {
            if(gameBoard[1][0] != o){
                return 3;
            }
        }
        if(gameBoard[2][1] == x && gameBoard[2][2] == x) {
            if(gameBoard[2][0] != o){
                return 6;
            }
        }
        if(gameBoard[2][0] == x && gameBoard[1][1] == x) {
            if(gameBoard[0][2] != o){
                return 2;
            }
        }
        if(gameBoard[2][2] == x && gameBoard[1][1] == x) {
            if(gameBoard[0][0] != o){
                return 0;
            }
        }
        return  -1;
    }
    
}
