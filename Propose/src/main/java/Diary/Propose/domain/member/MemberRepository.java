package Diary.Propose.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginId(String loginId);

//    private static Map<Long, Member> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    public Member save(Member member){
//        //ember.setId(++sequence);
//        log.info("save: member={}",member);
//        store.put(member.getId(),member);
//        return member;
//    }
//
//    public Optional<Member> findByLoginId(String loginId){
//        return findAll().stream().filter(m -> m.getLoginId().equals(loginId)).findFirst();
//    }
//
//    public List<Member> findAll(){
//        return new ArrayList<>(store.values());
//    }
//
//    public void clearStore(){
//        store.clear();
//    }
}
