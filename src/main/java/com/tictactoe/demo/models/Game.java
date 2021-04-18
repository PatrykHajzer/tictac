package com.tictactoe.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Game {

    private Board board;
    private String message;
    private Boolean endCondition;

    public Game() {
        this.board = createNewList();
        this.message = null;
        this.endCondition = false;
    }

    public Board createNewList() {
        return Board.builder()
                .boardList(Arrays.asList(Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank, Mark.blank))
                .build();
    }

}
