package Diary.Propose.domain.member;

import Diary.Propose.domain.letter.Letter;
import Diary.Propose.domain.perfume.Perfume;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String loginId;

    @Column(nullable = false, length = 10)
    private String name1;

    @Column(nullable = false, length = 10)
    private String name2;

    @Column(nullable = false, length = 30)
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Letter> letterList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Perfume> perfumeList = new ArrayList<>();
}
//깃 버전 테스트 .111111111
//버전 테스트 2.
