package spring_demo.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_demo.demo.entity.MemberEntity;
import spring_demo.demo.repository.MemberRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
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
}
