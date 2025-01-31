package my_when2meet.my_when2meet_spring.repository;

import my_when2meet.my_when2meet_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private  static Map<Long, Member> store = new HashMap<>();
    private  static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setUserid(++sequence);
        store.put(member.getUserid(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long userid) {
        return Optional.ofNullable(store.get(userid));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
