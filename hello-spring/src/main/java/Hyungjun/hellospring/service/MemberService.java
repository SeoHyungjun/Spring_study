package Hyungjun.hellospring.service;

import Hyungjun.hellospring.domain.Member;
import Hyungjun.hellospring.repository.MemberRepository;
import Hyungjun.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository; // = new MemoryMemberRepository();

    // 기존에 MemberService class를 만들 때 생성되던 memberRepository를 외부에서 넣어주는 방식으로 변경
    // memberService 입장에서 MemoryMemberRepository를 외부에서 넣어줌 == DI(Dependency Injection)라고 함
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public long join(Member member) {
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findByMembers() {
        return memberRepository.finaAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }

}
