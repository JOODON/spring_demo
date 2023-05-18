package spring_demo.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring_demo.demo.dto.ToDoDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    public ToDoEntity() {

    }

    public static ToDoEntity toToDoEntity(ToDoDTO toDoDTO) {
        ToDoEntity toDoEntity = new ToDoEntity();

        toDoEntity.setTodoTitle(toDoDTO.getTodoTitle());
        toDoEntity.setTodoItem(toDoDTO.getTodoItem());
        toDoEntity.setName("의문의 사나이");

        return toDoEntity;
    }
}