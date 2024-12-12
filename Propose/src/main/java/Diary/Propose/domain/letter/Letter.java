package Diary.Propose.domain.letter;

import Diary.Propose.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer day;

    @Column( length = 20)
    private String title;

    @Column( length = 20)
    private String date;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Enumerated(EnumType.STRING)
    private LetterType letterType;//기록 종류
    //만약 중복 선택을 하고싶다면 List<String>으로 짜보자.

    private String score;// 하루 점수 -> 셀렉트 박스로

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}

