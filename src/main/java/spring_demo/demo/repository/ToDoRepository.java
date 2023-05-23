package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.entity.ToDoEntity;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
    List<ToDoEntity> findByMemberEmail(String email);
    //Member 에 리스트에 넣어주기 위해서 회원에 맞는 ToDoEntity 를 가지고 오기
}
