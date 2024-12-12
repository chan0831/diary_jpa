package Diary.Propose.domain.perfume;

import Diary.Propose.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Perfume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String perfumeName; //텍스트박스

    private String brand; //텍스트박스

    @Column(nullable = false)
    private String topNote; //텍스트박스

    @Column(nullable = false)
    private String middleNote; //텍스트박스

    @Column(nullable = false)
    private String baseNote; //텍스트박스

    @Column
    private String rating; //셀렉트 박스

    @Column
    private String review; //텍스트박스

    @ElementCollection
    @CollectionTable(name = "perfume_seasons", joinColumns = @JoinColumn(name = "perfume_id"))
    @Column(name = "season")
    private List<String> season; //멀티 체크박스

    @Column
    private String date; //텍스트박스

    @ElementCollection
    @CollectionTable(name = "perfume_accords", joinColumns = @JoinColumn(name = "perfume_id"))
    @Column(name = "accord")
    private List<String> accords; //멀티 체크박스

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
