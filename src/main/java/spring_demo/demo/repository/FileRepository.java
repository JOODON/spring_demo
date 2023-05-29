package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_demo.demo.entity.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity , Long> {


}
