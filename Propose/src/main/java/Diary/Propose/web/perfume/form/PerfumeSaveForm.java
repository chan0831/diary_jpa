package Diary.Propose.web.perfume.form;

import Diary.Propose.domain.perfume.PerfumeRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class PerfumeSaveForm {

    @NotBlank
    private String PerfumeName;

    @NotBlank
    private String brand;

    @NotBlank
    private String date;

    private List<String> accords;

    @NotBlank
    private String topNote;

    @NotBlank
    private String middleNote;

    @NotBlank
    private String baseNote;

    private List<String> season;

    private String rating;

    @NotBlank
    private String review;

    @NotNull
    private Long photoId;

    private String photoName;
    private MultipartFile attachFile;
    private List<MultipartFile> imageFiles;
}
