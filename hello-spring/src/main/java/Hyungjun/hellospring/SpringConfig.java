package Hyungjun.hellospring;

import Hyungjun.hellospring.repository.JdbcTemplateMemberRepository;
import Hyungjun.hellospring.repository.JpaMemberRepository;
import Hyungjun.hellospring.repository.MemberRepository;
import Hyungjun.hellospring.repository.JdbcMemberRepository;
import Hyungjun.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    //    private DataSource dataSource;
//
//    @Autowired
//    public  SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    // @Configuration 등록 후 @Bean을 하면 스프링 빈을 등록하겠다는 뜻
    // 이런식으로 작성하면 스프링이 실행될 때 configuration 읽어오고
    // @Bean은 스프링 빈에 등록하라고 인식 -> 로직을 호출해서 스프링빈에 등록
    // 컴포넌트 스캔의 경우 나중에 구현 클래스(ex MemoryMemberRepository -> DbMemberRepository)가 변경 될 경우
    // 여러 파일을 바꿔야하는데, 자바 코드로 스프링빈을 등록하면 설정 파일만 변경하면 됨
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository(); // MemberRepository는 인터페이스라 new가 안됨, 구현체인 MemoryMemberRepository 사용
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
