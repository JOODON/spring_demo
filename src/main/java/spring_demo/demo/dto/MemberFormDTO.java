package spring_demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.entity.ToDoEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberFormDTO {

    private Long id;

    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입력값 입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String email;

    @NotEmpty(message = "비밀번호는 필수 입력 값 입니다.")
    private String password;

    @NotEmpty(message = "주소는 필수 입력 값 입니다.")
    private String address;

    private List<ToDoEntity> todos = new ArrayList<>();

    public static MemberFormDTO toMemberDto(MemberEntity member){
        MemberFormDTO memberFormDTO = new MemberFormDTO();

        memberFormDTO.setId(member.getId());
        memberFormDTO.setName(member.getName());
        memberFormDTO.setEmail(member.getEmail());
        memberFormDTO.setPassword(member.getPassword());
        memberFormDTO.setAddress(member.getAddress());

        return memberFormDTO;
    }
}
