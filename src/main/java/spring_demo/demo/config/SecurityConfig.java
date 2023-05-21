package spring_demo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HTTP 요청에 대한 보안 구성을 설정합니다.
        // 예를 들어, 인증, 권한, 로그인 페이지, 로그아웃 등을 구성할 수 있습니다.
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 암호화 부분
        return new BCryptPasswordEncoder();
    }
}
