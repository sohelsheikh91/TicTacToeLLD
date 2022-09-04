package com.example.tictactoegame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicTacToeGameApplication {

    public static void main(String[] args) {

        Game game = new Game();
        System.out.println("game winner is: " + game.startGame());

        //SpringApplication.run(TicTacToeGameApplication.class, args);
    }

}
