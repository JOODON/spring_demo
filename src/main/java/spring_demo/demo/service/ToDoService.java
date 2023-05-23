package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_demo.demo.config.SecurityUtils;
import spring_demo.demo.dto.BoardDTO;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.entity.BoardEntity;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.entity.ToDoEntity;
import spring_demo.demo.repository.BoardRepository;
import spring_demo.demo.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final MemberService memberService;
    public List<ToDoDTO> toDoDTOList(){
        List<ToDoEntity> toDoEntities = toDoRepository.findAll();
        List<ToDoDTO> toDoDTOList = new ArrayList<>();

        //Entity -> DAO 변환작업해주기!
        for (ToDoEntity t : toDoEntities){
            toDoDTOList.add(ToDoDTO.toToDoDto(t));
        }

        return toDoDTOList;
    }
    public List<ToDoDTO> getToDoListForMember(String email){
        List<ToDoEntity> toDoEntityList = toDoRepository.findByMemberEmail(email);

        List<ToDoDTO> toDoDTOList = new ArrayList<>();

        for (ToDoEntity toDoEntity : toDoEntityList){
            ToDoDTO toDoDTO = new ToDoDTO();

            toDoDTO.setId(toDoEntity.getId());
            toDoDTO.setTodoTitle(toDoEntity.getTodoTitle());
            toDoDTO.setTodoItem(toDoEntity.getTodoItem());
            toDoDTO.setName(toDoEntity.getName());

            toDoDTOList.add(toDoDTO);
        }

        return toDoDTOList;
    }

    public void save(ToDoDTO toDoDTO) {

        String name = SecurityUtils.getCurrentUserId();

        MemberEntity member = memberService.findByMember(name);

        ToDoEntity toDoEntity=ToDoEntity.toToDoEntity(toDoDTO,member);

        toDoRepository.save(toDoEntity);
    }

    public void deleteById(Long id) {

        toDoRepository.deleteById(id);
    }

}