package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring_demo.demo.entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
}
