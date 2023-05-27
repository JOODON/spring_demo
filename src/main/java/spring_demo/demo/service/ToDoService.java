package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_demo.demo.config.SecurityUtils;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.entity.ToDoEntity;
import spring_demo.demo.repository.MemberRepository;
import spring_demo.demo.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    private final MemberService memberService;


    public void save(ToDoDTO toDoDTO) {

        String name = SecurityUtils.getCurrentUserId();

        MemberEntity member = memberService.findByMember(name);
        //이름으로 아이디값을 찾아옴 근데 이부분은 수정해야됨 이메일로 가져오늘걸로!

        ToDoEntity toDoEntity=ToDoEntity.toToDoEntity(toDoDTO,member);

        toDoRepository.save(toDoEntity);
    }

    public void deleteById(Long id) {

        toDoRepository.deleteById(id);
    }


//    public List<ToDoDTO> toDoDTOList(){
//        //전체를 출력해주는 List
//        List<ToDoEntity> toDoEntities = toDoRepository.findAll();
//        List<ToDoDTO> toDoDTOList = new ArrayList<>();
//
//        //Entity -> DAO 변환작업해주기!
//        for (ToDoEntity t : toDoEntities){
//            toDoDTOList.add(ToDoDTO.toToDoDto(t));
//        }
//
//        return toDoDTOList;
//    }

    public List<ToDoDTO> toDoDTOListByMemberId(Long id) {
        //MEMBER_ID 값을 매개변수로 받아서 출력해주는 메소드
         List<ToDoEntity> toDoEntities = toDoRepository.findAllByMember_Id(id);

        List<ToDoDTO> toDoDTOList = new ArrayList<>();

        for (ToDoEntity t : toDoEntities){
            toDoDTOList.add(ToDoDTO.toToDoDto(t,id));
        }

        return toDoDTOList;
    }
}