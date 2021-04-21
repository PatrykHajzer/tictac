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
    public GameResponse getBoard(){
        return GameResponse.builder()
                .boardList(ticTacToeService.getBoard())
                .message(ticTacToeService.infoResponse())
                .build();
    }

    @PostMapping("/game")
    public GameResponse makeMove(@RequestBody Board board){
        return GameResponse.builder()
                .boardList(ticTacToeService.makeMove(board))
                .message(ticTacToeService.infoResponse())
                .build();
    }
}
