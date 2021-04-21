package com.tictactoe.demo;

import com.tictactoe.demo.models.Board;
import com.tictactoe.demo.models.Game;
import com.tictactoe.demo.models.Mark;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicTacToeService {

    private final Game game;

    public TicTacToeService() {
        this.game = new Game();
    }

    public Board getBoard() {
        return game.getBoard();
    }

    public void makeMove(Board board) {
        playerMove(board);
        computerMove();
    }

    public void playerMove(Board board) {
        game.setState(Game.GameState.PlayerMove);
        game.setBoard(board);
        checkGameStatusFor(Mark.X);
    }

    private void computerMove() {
        game.setState(Game.GameState.ComputerMove);
        calculateComputerMove();
    }

    private void calculateComputerMove() {
        if(isFirstMove()) {
            randomComputerMark();
        }
    }

    private void randomComputerMark() {

    }

    private boolean isFirstMove() {
        return game.getBoard().getBoardList().stream().noneMatch(el -> el.equals(Mark.O));
    }

    public String infoResponse() {
        return game.getGameInfo();
    }

    private void checkGameStatusFor(Mark markType) {
        if (checkWinningCondition(markType)) {
            game.setState(Game.GameState.End);
            game.setGameInfo("Player: " + markType + " won");
        }
        if (checkDrawCondition()){
            game.setState(Game.GameState.End);
            game.setGameInfo("We have draw");
        }
    }

    private boolean checkDrawCondition() {
        List<Mark> boardList = game.getBoard().getBoardList();
        return boardList.stream().noneMatch(el -> el.equals(Mark.blank));
    }

    private boolean checkWinningCondition(Mark markType) {
        List<Mark> boardList = game.getBoard().getBoardList();
//        0 | 1 | 2
//       -----------
//        3 | 4 | 5
//       -----------
//        6 | 7 | 8
        return boardList.get(0) == markType && boardList.get(1) == markType && boardList.get(2) == markType
                || boardList.get(3) == markType && boardList.get(4) == markType && boardList.get(5) == markType
                || boardList.get(6) == markType && boardList.get(7) == markType && boardList.get(8) == markType
                || boardList.get(0) == markType && boardList.get(3) == markType && boardList.get(6) == markType
                || boardList.get(1) == markType && boardList.get(4) == markType && boardList.get(7) == markType
                || boardList.get(2) == markType && boardList.get(5) == markType && boardList.get(8) == markType
                || boardList.get(0) == markType && boardList.get(4) == markType && boardList.get(8) == markType
                || boardList.get(6) == markType && boardList.get(4) == markType && boardList.get(2) == markType;
    }
}
