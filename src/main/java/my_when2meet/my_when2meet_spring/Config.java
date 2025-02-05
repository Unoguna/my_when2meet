package my_when2meet.my_when2meet_spring;

import my_when2meet.my_when2meet_spring.repository.JdbcTemplateMemberRepository;
import my_when2meet.my_when2meet_spring.repository.MemberRepository;
import my_when2meet.my_when2meet_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    private final DataSource dataSource;

    public Config(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
