package my_when2meet.my_when2meet_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninContoroller {

    @GetMapping("signin")
    public String signin(){
        return "signin";
    }
}
