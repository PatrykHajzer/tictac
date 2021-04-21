package com.tictactoe.demo.models;

import lombok.Data;
import java.util.Arrays;

@Data
public class Game {

    private Board board;
    private GameState state;
    private String gameInfo;

    public enum GameState {
        PlayerMove, ComputerMove, Idle,  Start, End
    }


    public Game() {
        this.board = createNewList();
        this.state = GameState.Start;
        this.gameInfo = null;
    }

    private Board createNewList() {
        return Board.builder()
                .boardList(Arrays.asList(Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank))
                .build();
    }

}
