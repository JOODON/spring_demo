package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_demo.demo.entity.ChatEntity;


public interface ChatRepository extends JpaRepository<ChatEntity,Long> {

}
