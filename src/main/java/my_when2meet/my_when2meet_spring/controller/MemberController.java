package my_when2meet.my_when2meet_spring.controller;

import my_when2meet.my_when2meet_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }



}
