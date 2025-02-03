package my_when2meet.my_when2meet_spring.service;

import my_when2meet.my_when2meet_spring.domain.Member;
import my_when2meet.my_when2meet_spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    //input이 java.class가 아니라 interface인 이유: interface를 사용하는 다양한 객체들에 사용 할 수 있게 하려고 범용성을 위해..!
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getUserid();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long userId){
        return memberRepository.findByUserId(userId);
    }

}
