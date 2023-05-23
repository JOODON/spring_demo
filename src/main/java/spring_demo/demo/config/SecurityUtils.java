package spring_demo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.service.MemberService;

import java.security.Principal;

public class SecurityUtils {
    private MemberService memberService;

    public SecurityUtils(MemberService memberService) {
        this.memberService = memberService;
    }

    public static String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 현재 로그인된 사용자의 정보를 가져옴
        Object principal = authentication.getPrincipal();

        // UserDetails 인터페이스를 구현한 사용자 정보를 가진 경우
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        // UserDetails 인터페이스를 구현하지 않은 사용자 정보를 가진 경우
        return principal.toString();
    }
}
