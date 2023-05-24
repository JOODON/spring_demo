package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_demo.demo.dto.ToDoDTO;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.entity.ToDoEntity;

import java.lang.reflect.Member;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {


    List<ToDoEntity> findAllByMember_Id(Long id);
}
