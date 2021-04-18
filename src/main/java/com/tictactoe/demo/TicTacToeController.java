package com.tictactoe.demo;

import com.tictactoe.demo.models.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeController {
    private final TicTacToeService ticTacToeService;

    public TicTacToeController(TicTacToeService ticTacToeService) {
        this.ticTacToeService = ticTacToeService;
    }

    @GetMapping("/game")
    public BoardResponse getBoard(){
        return BoardResponse.builder()
                .boardList(ticTacToeService.getBoard())
                .message("New Game Created")
                .build();
    }

    @PostMapping("/game")
    public BoardResponse makeMove(@RequestBody Board board){
        return BoardResponse.builder()
                .boardList(ticTacToeService.makeMove(board))
                .message(ticTacToeService.infoResponse())
                .build();
    }
}
