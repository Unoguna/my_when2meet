package my_when2meet.my_when2meet_spring;

import my_when2meet.my_when2meet_spring.repository.MemberRepository;
import my_when2meet.my_when2meet_spring.repository.MemoryMemberRepository;
import my_when2meet.my_when2meet_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
