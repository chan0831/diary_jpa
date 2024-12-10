package Diary.Propose.domain.login;


import Diary.Propose.domain.member.Member;
import Diary.Propose.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){

//        Optional<Member> findMemberObtional = memberRepository.findByLoginId(loginId);
//        Member member = findMemberObtional.get();
//        if(member.getPassword().equals(password)){
//            return member;
//        }else{
//            return null;
//        } 이 로직이 아래와 같이 줄어들 수 있음

      /*
      Optional<Member> findMemberObtional = memberRepository.findByLoginId(loginId);
        return findMemberObtional.filter(m -> m.getPassword().equals(password))
                .orElse(null);
               */

        //이제 이 두 줄도 합쳐줄 수 있다.

        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);

    }
}


