package Diary.Propose.web.letter.form;

import Diary.Propose.domain.letter.LetterType;
import Diary.Propose.domain.letter.Score;
import Diary.Propose.domain.member.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class LetterSaveForm {


    private String title;


    @Range(min = 1 , max = 36500)
    private Integer day;


    private String date;


    private String contents;


    private LetterType letterType;

    private String score;

//    @NotNull
//    private Long photoId;
//
//    private String photoName;
//    private MultipartFile attachFile;
//    private List<MultipartFile> imageFiles;
}
