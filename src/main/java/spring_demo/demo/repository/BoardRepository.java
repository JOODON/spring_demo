package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_demo.demo.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

}
