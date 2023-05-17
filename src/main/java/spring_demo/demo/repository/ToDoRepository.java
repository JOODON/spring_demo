package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_demo.demo.entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {

}
