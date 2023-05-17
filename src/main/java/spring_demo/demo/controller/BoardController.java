package spring_demo.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring_demo.demo.dto.BoardDTO;
import spring_demo.demo.service.BoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping(value = "/")
    @CrossOrigin("http://localhost:3000/")
    public List<BoardDTO> viewBoard(){
        List<BoardDTO> boardDTOList = boardService.findAll();

        return boardDTOList;
    }
    @GetMapping("/detail/{id}")
    @CrossOrigin("http://localhost:3000/")
    public BoardDTO findByBoard(@PathVariable Long id){
        BoardDTO boardDTO=boardService.findById(id);

        if (boardDTO == null)
            System.out.println("존재하지 않는 데이터");

        return boardDTO;
    }

    @PostMapping("/write")
    @CrossOrigin("http://localhost:3000/")
    public BoardDTO writeBoard(BoardDTO boardDTO){
        boardService.saveBoard(boardDTO);

        return boardDTO;
    }
    @GetMapping("/update/{id}")
    @CrossOrigin("http://localhost:3000/")
    public BoardDTO updateBoard(BoardDTO boardDTO){
        BoardDTO board = boardService.findById(boardDTO.getId());

        return board;
    }
    @PostMapping("/update/{id}")
    @CrossOrigin("http://localhost:3000/")
    public BoardDTO updateAction(BoardDTO boardDTO){
        boardService.update(boardDTO);

        return boardDTO;
    }
}
