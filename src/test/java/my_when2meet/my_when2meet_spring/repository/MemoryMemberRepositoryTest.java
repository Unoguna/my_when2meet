package my_when2meet.my_when2meet_spring.repository;

import my_when2meet.my_when2meet_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member =  new Member();
        member.setId("kim");
        member.setName("Unoguna");
        member.setPassword("jeongho");

        repository.save(member);

        Member result = repository.findByUserId(member.getUserid()).get();
        assertThat(result).isEqualTo(member);
    }

}
