package spring_demo.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.service.MemberService;

import javax.persistence.*;

//회원은 1명 게시글은 여러개 회원 객체에서는 oneTwoMany
@Getter
@Setter
@AllArgsConstructor
@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String todoTitle;

    @NotNull
    private String todoItem;


    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    public ToDoEntity() {

    }

    public static ToDoEntity toToDoEntity(ToDoDTO toDoDTO) {
        ToDoEntity toDoEntity = new ToDoEntity();

        toDoEntity.setTodoTitle(toDoDTO.getTodoTitle());
        toDoEntity.setTodoItem(toDoDTO.getTodoItem());
        toDoEntity.setName(MemberService.getCurrentUserId());

        return toDoEntity;
    }
}