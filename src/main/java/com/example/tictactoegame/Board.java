package com.example.tictactoegame;

public class Board {
    int size;
    PlayingPiece board[][];

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){

        if(board[row][col] == null) {

            board[row][col] = playingPiece;
            return true;
        }
        return false;
    }
    public boolean getFreeSpaces(){
        for(int i = 0; i< size; i++){
            for(int j= 0; j< size; j++){

                if(board[i][j] == null) return true;
            }
        }
        return false;
    }
    public void printBoard(){

        for(int i = 0; i< size; i++){
            for(int j = 0; j< size; j++){
                if(board[i][j]== null)
                    System.out.print("  |");
                else
                    System.out.print( " " + board[i][j].currentPiece + " |");
            }
            System.out.println();
            System.out.println("-----------");

        }


    }

}
