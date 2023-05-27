package spring_demo.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import spring_demo.demo.config.SecurityUtils;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
    //하나의 회원에는 여러가지 ToDo가 들어갈수 있으므로 위와같이 설정

    public ToDoEntity() {

    }

    public void setMember(MemberEntity member) {
        if (this.member != null) {
            this.member.getTodos().remove(this);
        }

        this.member = member;

        // 컬렉션 초기화
        member.getTodos().size();

        member.getTodos().add(this);
    }


    public static ToDoEntity toToDoEntity(ToDoDTO toDoDTO, MemberEntity member) {
        ToDoEntity toDoEntity = new ToDoEntity();


        toDoEntity.setTodoTitle(toDoDTO.getTodoTitle());
        toDoEntity.setTodoItem(toDoDTO.getTodoItem());
        toDoEntity.setName(SecurityUtils.getCurrentUserId());

        toDoEntity.setMember(member);
        //연관관계 설정 부분

        return toDoEntity;
    }

}