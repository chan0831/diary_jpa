package Diary.Propose.domain.letter;

import lombok.Data;


@Data
public class Letter {

    private Long id;
    private Integer day;
    private String title;
    private String date;
    private String contents;

    private LetterType letterType;//기록 종류
    //만약 중복 선택을 하고싶다면 List<String>으로 짜보자.
    private String score;// 하루 점수 -> 셀렉트 박스로


    public Letter(){}

    public Letter(String title, Integer day, String date, String contents){
        this.date = date;
        this.day = day;
        this.title = title;
        this.contents = contents;

    }

}

