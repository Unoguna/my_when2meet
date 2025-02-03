package my_when2meet.my_when2meet_spring.service;

import my_when2meet.my_when2meet_spring.domain.Member;
import my_when2meet.my_when2meet_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setId("hello");
        member.setPassword("hi");
        member.setName("kim");

        //when
        Long saveUserId = memberService.join(member);

        //then
        Member findMember = memberRepository.findByUserId(saveUserId).get();
        assertEquals(member.getId(), findMember.getId());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setId("hello");
        member1.setName("it's me");
        member1.setPassword("mario");

        Member member2 = new Member();
        member2.setId("hello");
        member2.setName("it's me");
        member2.setPassword("mario");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
    }

}
