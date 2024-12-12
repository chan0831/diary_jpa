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

        Member member = Member.builder()
                .loginId("hongik")
                .password("617!")
                .name1("문서정")
                .name2("이찬우")
                .build();
        memberRepository.save(member);

        Letter letter = Letter.builder()
                .title("testDiary")
                .date("24.06.17")
                .day(408)
                .contents("생일")
                .build();
        letterRepository.save(letter);

        Perfume perfume = Perfume.builder()
                .perfumeName("바카라루쥬")
                .brand("메종 프란시스 커정")
                .date("23.12.11")
                .rating("4.5")
                .baseNote("가")
                .middleNote("나")
                .topNote("다")
                .build();
        perfumeRepository.save(perfume);

    }
}
