package Hyungjun.hellospring.controller;

import Hyungjun.hellospring.domain.Member;
import Hyungjun.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // spring이 실행될 때 MemberController가 생성됨.
    // 그때 생성자(Constructor)가 호출 됨
    // Autowired로 되어있으면, spring이 sping container에 있는 memberSerivce를 가져다 연결
    // 그러기 위해서 MemberService에 @Service를 추가해야 함
    // 이러한 방식을 Dependency Injection라고 함
    // @Controller, @Service, @Repository와 같이 설정하는건 컴포넌트 스캔 방식
    // 자동?방식으로 스프링 빈을 등록하는 과정
    // 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본적으로 싱글톤으로 등록(유일하게 하나만 등록해서 공유)
    // 따라서 같은 빈이면 같은 인스턴스
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
