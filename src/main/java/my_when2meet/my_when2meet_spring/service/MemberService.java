package my_when2meet.my_when2meet_spring.service;

import my_when2meet.my_when2meet_spring.domain.Member;
import my_when2meet.my_when2meet_spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

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
