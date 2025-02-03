package my_when2meet.my_when2meet_spring.repository;

import my_when2meet.my_when2meet_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void findById() {
        Member member =  new Member();
        member.setId("kim");
        member.setName("Unoguna");
        member.setPassword("jeongho");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll(){
        Member member1 =  new Member();
        member1.setId("kim1");
        member1.setName("Unoguna1");
        member1.setPassword("jeongho1");
        repository.save(member1);

        Member member2 =  new Member();
        member2.setId("kim1");
        member2.setName("Unoguna1");
        member2.setPassword("jeongho1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void findByName(){
        Member member =  new Member();
        member.setId("kim");
        member.setName("Unoguna");
        member.setPassword("jeongho");
        repository.save(member);

        Member member1 =  new Member();
        member1.setId("kim1");
        member1.setName("Unoguna");
        member1.setPassword("jeongho1");
        repository.save(member1);

        List<Member> result = repository.findByName("Unoguna");

        assertThat(result.size()).isEqualTo(2);

    }

}
