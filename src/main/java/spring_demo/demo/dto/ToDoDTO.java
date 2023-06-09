package spring_demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.entity.ToDoEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoDTO {

    private Long id;

    private String todoTitle;

    private String todoItem;

    private String name;

    private Long member_id;

    public static ToDoDTO toToDoDto(ToDoEntity t,Long memberId) {
        ToDoDTO toDoDTO = new ToDoDTO();

        toDoDTO.setId(t.getId());
        toDoDTO.setTodoTitle(t.getTodoTitle());
        toDoDTO.setTodoItem(t.getTodoItem());
        toDoDTO.setName(t.getName());
        toDoDTO.setMember_id(memberId);

        return toDoDTO;
    }

    public static ToDoDTO toToDoDto(ToDoEntity t) {
        ToDoDTO toDoDTO = new ToDoDTO();

        toDoDTO.setId(t.getId());
        toDoDTO.setTodoTitle(t.getTodoTitle());
        toDoDTO.setTodoItem(t.getTodoItem());
        toDoDTO.setName(t.getName());

        return toDoDTO;
    }
}
