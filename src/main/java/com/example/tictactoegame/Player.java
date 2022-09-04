package com.example.tictactoegame;

import lombok.Data;

@Data
public class Player {
    String name;
    PlayingPiece piece;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
    }
}
