package spring_demo.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring_demo.demo.config.SecurityUtils;
import spring_demo.demo.dto.MemberFormDTO;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.service.MemberService;

import javax.validation.Valid;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;
    @GetMapping("/new")
    public String memberForm(Model model){

        model.addAttribute("memberFormDTO",new MemberFormDTO());
        model.addAttribute("currentUser", SecurityUtils.getCurrentUserId());
        return "ToDo/member/signUpPage";
    }

    @PostMapping("/new")
    public String memberForm(@Valid MemberFormDTO memberFormDTO, BindingResult bindingResult , Model model){
        if (bindingResult.hasErrors()){
            return "ToDo/member/signUpPage";
        }
        try {
            MemberEntity member = MemberEntity.createMember(memberFormDTO,passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            return "ToDo/member/signUpPage";
        }

        return "redirect:/members/login";
    }

    @GetMapping("/login")
    public String loginMember(Model model){
        model.addAttribute("currentUser", SecurityUtils.getCurrentUserId());

        return "ToDo/member/loginPage";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 화인해주세요");

        return "ToDo/member/loginPage";
    }
}
