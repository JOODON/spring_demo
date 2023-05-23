package spring_demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_demo.demo.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    MemberEntity findByEmail(String email);

    MemberEntity findByName (String name);
}
