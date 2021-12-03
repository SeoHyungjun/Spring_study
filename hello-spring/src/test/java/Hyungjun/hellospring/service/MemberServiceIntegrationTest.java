package Hyungjun.hellospring.service;

import Hyungjun.hellospring.domain.Member;
import Hyungjun.hellospring.repository.MemberRepository;
import Hyungjun.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // db에 transaction이란 개념이 있어서, commit을 해야 함.
               // 그런데 test 후 rollback을 해버린다면? 같은 테스트를 여러번 가능
               // 이 방법이 @Transactional, 이걸 사용하면 지우는 과정을 없애도 됨.
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService; //= new MemberService();
    @Autowired MemberRepository memberRepository; // = new MemoryMemberRepository();

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        long saveID = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveID).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}