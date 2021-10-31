package Hyungjun.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /*
    "url:8080/hello-mvc?name=hyungjun"을 주소창에 입력하면

     웹 서버에가 전달 받게되고, 내장 톰켓 서버가 먼저 받는다.

    내장 톰켓 서버는 hello-mvc가 왔다고 spring에게 알려준다.

    spring는 hello-mvc가 HelloController에 매핑 되어있으므로,
    HelloController의 hello-mvc가 매핑되어있는 함수를 실행한다.
    코드에 의해서 model에 name으로 들어온 값을 추가하고 hello-template를 spring에게 return한다.

    그러면 viewResolver가 동작하는데, return으로 받은 hello-template를 찾아서 thymeleaf 템플릿 엔진에게 처리를 요청한다.

    그러면 템플릿 엔진이 변환 후 다시 웹 브라우저에게 변환된 html을 반환한다.
    */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 body부분에 이 내용을 직접 넣어주겠다
    // return이 hello + name이므로 html이 아닌 그냥 문자열을 보내주는 것.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 기본으로 json으로 반환 됨
    /* ResponseBody가 없을 경우 hello-mvc의 template을 찾는 방식으로 동작
    (viewResolver가 template을 찾아서 돌려줌)

    그러나 ResponseBody가 있을 경우 응답을 http 프로토콜의 body에 넣어서 응답

    그 중 객체가 반환되면 스프링은 default방식으로 json으로 만들어서 반환
    (리턴값이 string일 경우 StringConverter가, 객체일 경우 JsonConverter가 동작)

    @ResponseBody 를 사용할 경우
        - HTTP의 BODY에 문자 내용을 직접 반환
        - viewResolver 대신에 HttpMessageConverter 가 동작
        - 기본 문자처리: StringHttpMessageConverter
        - 기본 객체처리: MappingJackson2HttpMessageConverter
        - byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
    */
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        // java에는 getter and setter라는게 존재 함 (프로퍼티 방식으로 불리기도 함)
        // name의 경우 private라 외부에서 접근 불가능하므로
        // getter와 setter를 사용해서 외부에서 접근
        // 그러므로 getter와 setter는 public로 선언
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
