package Hyungjun.hellospring;

import Hyungjun.hellospring.aop.TimeTraceAop;
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

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
