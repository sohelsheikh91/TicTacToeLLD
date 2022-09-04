package com.example.tictactoegame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Deque<Player> players;
    Board gameBoard;

    public Game() {
        players = new LinkedList<>();
        initialize();
    }

    void initialize(){

        Player player1 = new Player("Sohel", new PieceX(PieceType.X));

        Player player2 = new Player("Akshay", new PieceX(PieceType.O));

        players.add(player1);

        players.add(player2);

        gameBoard = new Board(3);
    }
    String startGame(){

        boolean noWinner = true;
        while(noWinner){

            Player player = players.removeFirst();
            gameBoard.printBoard();

            Scanner in = new Scanner(System.in);
            boolean hasFreeSpaces = gameBoard.getFreeSpaces();

            if(!hasFreeSpaces){
                noWinner = false;
                continue;
            }
            System.out.print("Please enter you point : ");
            String s = in.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputCol = Integer.valueOf(values[1]);

            boolean playerSuccessfullyAdded = gameBoard.addPiece(inputRow, inputCol, player.piece);

            if(!playerSuccessfullyAdded){
                System.out.println("Invalid Input Added");
                players.addFirst(player);
                continue;
            }
            players.addLast(player);
            boolean isWinner = isThereWinner(inputRow, inputCol, player.piece);
            if(isWinner){
                return player.name;
            }
        }
        return "tie";
    }

    private boolean isThereWinner(int inputRow, int inputCol, PlayingPiece piece) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i = 0; i< gameBoard.size ; i++ ){

            if(gameBoard.board[inputRow][i] == null || gameBoard.board[inputRow][i].currentPiece != piece.currentPiece){
                rowMatch = false;
            }
        }
        for(int i = 0; i< gameBoard.size ; i++ ){

            if(gameBoard.board[i][inputCol] == null || gameBoard.board[i][inputCol].currentPiece != piece.currentPiece){
                columnMatch = false;
            }
        }
        for(int i = 0; i< gameBoard.size ; i++ ){

            if(gameBoard.board[i][i] == null || gameBoard.board[i][i].currentPiece != piece.currentPiece){
                diagonalMatch = false;
            }
        }
        for(int i = 0, j = gameBoard.size-1; i< gameBoard.size; i++ , j--){

            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].currentPiece != piece.currentPiece){
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
