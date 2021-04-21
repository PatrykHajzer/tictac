package com.tictactoe.demo;

import com.tictactoe.demo.models.Board;
import lombok.Builder;

@Builder
public class GameResponse {
    private final Board boardList;
    private final String message;
}
