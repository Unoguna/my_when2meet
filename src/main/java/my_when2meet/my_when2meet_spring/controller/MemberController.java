package my_when2meet.my_when2meet_spring.controller;

import jakarta.servlet.http.HttpServletResponse;
import my_when2meet.my_when2meet_spring.domain.Member;
import my_when2meet.my_when2meet_spring.domain.Schedule;
import my_when2meet.my_when2meet_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/signinForm";
    }

    @GetMapping(value = "/members")
    public String list(Model model){
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    @PostMapping(value="/members/new")
    public String create(MemberForm form){

        Member member = new Member();

        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setName(form.getName());

        memberService.join(member);

        return"redirect:/";
    }

    @PostMapping(value="/members/login")
    public String login(MemberForm form, HttpServletResponse response) throws IOException {
        Member member = new Member();

        member.setId(form.getId());
        member.setPassword(form.getPassword());
        member.setName(form.getName());

        if(memberService.login(member).isEmpty()){  //로그인 실패
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=utf-8");
            out.println("<script> alert('Wrong ID or Password');");
            out.println("history.go(-1); </script>");
            out.close();

            return "redirect:/";
        }
        else{   //로그인 성공
            Member user = memberService.login(member).getFirst();
            List <Schedule> schedules = memberService.findSchedules(member.getScheduleIdx());
            return "schedule/mainPage";
        }
    }
}
