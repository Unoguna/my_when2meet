package my_when2meet.my_when2meet_spring.repository;

import my_when2meet.my_when2meet_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findByUserId(Long userid);
    Optional<Member> findById(String id);
    List<Member> findByName(String name);
    List<Member> findAll();
    List<Member> canLongin(String id, String password);

}
