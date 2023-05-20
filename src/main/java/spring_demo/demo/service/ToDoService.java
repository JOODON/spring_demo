package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_demo.demo.dto.BoardDTO;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.entity.BoardEntity;
import spring_demo.demo.entity.ToDoEntity;
import spring_demo.demo.repository.BoardRepository;
import spring_demo.demo.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDoDTO> toDoDTOList(){
        List<ToDoEntity> toDoEntities = toDoRepository.findAll();
        List<ToDoDTO> toDoDTOList = new ArrayList<>();

        //Entity -> DAO 변환작업해주기!
        for (ToDoEntity t : toDoEntities){
            toDoDTOList.add(ToDoDTO.toToDoDto(t));
        }

        return toDoDTOList;
    }

    public void save(ToDoDTO toDoDTO) {
        ToDoEntity toDoEntity=ToDoEntity.toToDoEntity(toDoDTO);

        toDoRepository.save(toDoEntity);
    }

    public void deleteById(Long id) {

        toDoRepository.deleteById(id);
    }
}
