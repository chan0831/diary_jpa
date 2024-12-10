package Diary.Propose.domain.photo;

import lombok.Data;

import java.util.List;

@Data
public class Photo {

    private Long id;
    private String photoName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
