package Hyungjun.hellospring.repository;

import Hyungjun.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 전체 테스트를 실행시키면 순서가 보장되어있지 않아서 먼저 실행된 부분에서 저장된 Member가 있어서 오류 발생
    // 설계할 때 순서에 의존하지 않도록 해야함.
    // 각 테스트가 끝날때마자 repository를 지워주는 동작이 필요
    // 이번 경우는 먼저 repository를 개발 후 Test Case를 작성했는데
    // Test Case를 작성한 뒤 구현 클래스를 만들어서 돌려보는 방식-> 테스트 주도 개발 (TDD, Test Driven Development)
    @AfterEach // 각 테스트가 끝나면 실행, 콜백메소, 각 메소드가 실행된 두 실행
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("HJ");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("HJ1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("HJ2");
        repository.save(member2);

        Member result = repository.findByName("HJ1").get();

        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("HJ1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("HJ2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("HJ3");
        repository.save(member3);

        List<Member> result = repository.finaAll();

        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}
