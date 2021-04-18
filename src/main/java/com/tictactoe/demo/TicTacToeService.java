package com.tictactoe.demo;

import com.tictactoe.demo.models.Board;
import com.tictactoe.demo.models.Game;
import com.tictactoe.demo.models.Mark;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class TicTacToeService {

    private final Game game;

    public TicTacToeService() {
        this.game = new Game();
    }

    public Board getBoard() {
        return game.getBoard();
    }

    public void updateBoard(Board board) {
        game.setBoard(board);
    }

    public Board makeMove(Board board) {
        updateBoard(board);
        checkStatus();
        makeResponseMove();
        checkStatus();
    }

    private void makeResponseMove() {

    }

    public String infoResponse() {
        return checkStatus();
    }

    private String checkStatus() {
        checkWinningCondition();
        checkDrawCondition();
    }

    private void checkDrawCondition() {
        if (noMoreMovesCondition()) {

        }
    }

    private boolean noMoreMovesCondition() {
        return false;
    }

    private void checkWinningCondition() {

    }
}
