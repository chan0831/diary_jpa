package Diary.Propose.web.converter;

import Diary.Propose.domain.letter.Letter;
import Diary.Propose.domain.member.Member;
import Diary.Propose.web.letter.form.LetterSaveForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LetterConverter {

    public static Letter toNewLetter(LetterSaveForm form, Member member){
        log.info("Converting form to letter: {}", form); // 이 로그로 데이터를 확인

        return Letter.builder()
                .title(form.getTitle())
                .date(form.getDate())
                .day(form.getDay())
                .contents(form.getContents())
                .letterType(form.getLetterType())
                .score(form.getScore())
                .member(member)
                .build();
    }

    public static Letter updateLetter(Letter letter, Letter updateParam){
        return Letter.builder()
                .id(letter.getId())
                .title(updateParam.getTitle())
                .date(updateParam.getDate())
                .day(updateParam.getDay())
                .contents(updateParam.getContents())
                .letterType(updateParam.getLetterType())
                .score(updateParam.getScore())
                .build();
    }
}
