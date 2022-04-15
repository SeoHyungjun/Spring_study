package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderSerivce;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        //MemberService memberService = new MemberServiceImpl();
        //OrderSerivce orderSerivce = new OrderServiceImpl();
        MemberService memberService = appConfig.memberService();
        OrderSerivce orderSerivce = appConfig.orderSerivce();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderSerivce.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
