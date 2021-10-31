package Hyungjun.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
}
