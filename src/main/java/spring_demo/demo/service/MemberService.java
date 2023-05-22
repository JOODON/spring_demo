package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.repository.MemberRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    public MemberEntity saveMember(MemberEntity member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    public void validateDuplicateMember(MemberEntity member){
        System.out.println(member.getName());
        MemberEntity findMember = memberRepository.findByEmail(member.getEmail());

        if (findMember != null)
            throw new IllegalStateException("이미 가입된 회원입니다");

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 주어진 사용자 이름(username)을 기반으로 MemberEntity 객체를 데이터베이스에서 찾기.
        MemberEntity member = memberRepository.findByEmail(username);

        // MemberEntity 객체가 존재하지 않으면, UsernameNotFoundException 예외를 발생.
        if (member == null){
            throw new UsernameNotFoundException(username);
        }

        // MemberEntity 객체를 기반으로 Spring Security의 UserDetails 구현체인 User 객체를 생성하여 반환.
        // User 객체의 속성으로는 사용자 이름, 비밀번호, 역할(롤)이 포함.
        return User.builder()
                .username(member.getName()) // 사용자 이름 설정
                .password(member.getPassword()) // 비밀번호 설정
                .roles(member.getRole().toString()) // 역할(롤) 설정
                .build(); // User 객체 생성
    }

}
