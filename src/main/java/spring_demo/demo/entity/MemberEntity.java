package spring_demo.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.metamodel.model.domain.internal.MapMember;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring_demo.demo.constant.Role;
import spring_demo.demo.dto.MemberFormDTO;

import javax.persistence.*;
import java.lang.reflect.Member;

@Entity
@Table(name = "MEMBER")
@Data
@ToString
public class MemberEntity {
    @Id
    @Column(name = "MEMBER_ID")
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static MemberEntity createMember(MemberFormDTO memberFormDTO, PasswordEncoder passwordEncoder){
        MemberEntity member = new MemberEntity();

        member.setName(memberFormDTO.getName());
        member.setEmail(memberFormDTO.getEmail());
        member.setAddress(memberFormDTO.getAddress());
        String password = passwordEncoder.encode(memberFormDTO.getPassword());
        member.setPassword(password);
        member.setRole(Role.USER);

        return member;
    }
}
