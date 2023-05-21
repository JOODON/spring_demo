package spring_demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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

    private String address;
}
