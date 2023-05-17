package spring_demo.demo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_demo.demo.dto.BoardDTO;
import spring_demo.demo.entity.BoardEntity;
import spring_demo.demo.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public List<BoardDTO> findAll(){
        List<BoardEntity> boardEntities =boardRepository.findAll();
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (BoardEntity b : boardEntities){
            boardDTOS.add(BoardDTO.toBoardDTO(b));
        }
        return boardDTOS;
    }
    public BoardDTO findById(Long id){
        Optional<BoardEntity> optionalBoardEntity=boardRepository.findById(id);
        //Optional -> null 값이 나올수도 있기 때문에 위와같은 값으로 감싸주기
        //객체 비어있는지 체크!
        if (optionalBoardEntity.isPresent()){
            BoardEntity boardEntity = optionalBoardEntity.get();
            return BoardDTO.toBoardDTO(boardEntity);
        }
        return null;
    }
    public void saveBoard(BoardDTO boardDTO){
        BoardEntity boardEntity=BoardEntity.toBoardEntity(boardDTO);
        boardRepository.save(boardEntity);
    }
    public BoardDTO update(BoardDTO boardDTO){
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDTO);
        boardRepository.save(boardEntity);

        return findById(boardDTO.getId());
    }
}
