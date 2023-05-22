package spring_demo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import spring_demo.demo.service.MemberService;

import java.lang.reflect.Member;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        // HTTP 요청에 대한 보안 구성을 설정합니다.
        http.authorizeRequests()
                // "/" 경로는 모든 사용자에게 허용합니다.
                .antMatchers("/").permitAll()
                // "/members/new" 경로는 모든 사용자에게 허용합니다.
                .antMatchers("/members/new").permitAll()
                // "/members/login" 경로는 모든 사용자에게 허용합니다.
                .antMatchers("/members/login").permitAll()
                // "/members/login/error" 경로는 모든 사용자에게 허용합니다.
                .antMatchers("/members/login/error").permitAll()
                // 나머지 모든 경로는 인증된 사용자만 허용합니다.
                .anyRequest().authenticated()
                .and()
                // 로그인 관련 설정을 구성합니다.
                .formLogin()
                // 로그인 페이지의 경로를 "/members/login"으로 설정합니다.
                .loginPage("/members/login")
                // 로그인 성공 시 이동할 기본 경로를
                .defaultSuccessUrl("/Todo")
                // 사용자명 파라미터의 이름을 "email"로 설정합니다.
                .usernameParameter("email")
                // 비밀번호 파라미터의 이름을 "password"로 설정합니다.
                .passwordParameter("password")
                // 로그인 실패 시 이동할 경로를 "/members/login/error"로 설정합니다.
                .failureForwardUrl("/members/login/error")
                .and()
                // 로그아웃 관련 설정을 구성합니다.
                .logout()
                // 로그아웃 요청의 경로를 "/members/logout"으로 설정합니다.
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                // 로그아웃 성공 시 이동할 경로를 "/"로 설정합니다.
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 인증을 위해 MemberService를 사용하고, 비밀번호 인코딩에 PasswordEncoder를 사용합니다.
        auth.userDetailsService(memberService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder를 사용하여 비밀번호를 암호화합니다.
        return new BCryptPasswordEncoder();
    }
}
