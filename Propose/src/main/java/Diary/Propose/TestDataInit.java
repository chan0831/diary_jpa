package Diary.Propose;

import Diary.Propose.domain.letter.Letter;
import Diary.Propose.domain.letter.LetterRepository;
import Diary.Propose.domain.member.Member;
import Diary.Propose.domain.member.MemberRepository;
import Diary.Propose.domain.perfume.Perfume;
import Diary.Propose.domain.perfume.PerfumeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;
    private final LetterRepository letterRepository;
    private final PerfumeRepository perfumeRepository;

    @PostConstruct
    public void init(){

        Member member = new Member();
        member.setLoginId("hongik");
        member.setPassword("617!");
        member.setName1("문서정");
        member.setName2("이찬우");

        Letter letter = new Letter();
        letter.setTitle("testDiary");
        letter.setDate("24.06.17");
        letter.setDay(408);
        letter.setContents("생일");
        memberRepository.save(member);
        letterRepository.save(letter);

        Perfume perfume = new Perfume();
        perfume.setPerfumeName("바카라루쥬");
        perfume.setBrand("메종 프란시스 커정");
        perfume.setDate("23.12.11");
        perfume.setRating("4.5");

        perfumeRepository.save(perfume);
    }
}
