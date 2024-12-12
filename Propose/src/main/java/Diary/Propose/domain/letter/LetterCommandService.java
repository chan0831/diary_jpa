package Diary.Propose.domain.letter;

import Diary.Propose.apiPayload.code.status.ErrorStatus;
import Diary.Propose.apiPayload.exception.GeneralException;
import Diary.Propose.web.converter.LetterConverter;
import Diary.Propose.web.letter.form.LetterSaveForm;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LetterCommandService {

    private final LetterRepository letterRepository;

    public void updateLetter(Long id, Letter updateParam){

        Letter letter = letterRepository.findById(id)
                .orElseThrow(()-> new GeneralException(ErrorStatus.LETTER_NOT_FOUND));

        Letter updatedLetter = LetterConverter.updateLetter(letter, updateParam);
        letterRepository.save(updatedLetter);

    }

}
