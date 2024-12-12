package Diary.Propose.domain.perfume;

import Diary.Propose.apiPayload.code.status.ErrorStatus;
import Diary.Propose.apiPayload.exception.GeneralException;
import Diary.Propose.web.converter.PerfumeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerfumeCommandService {

    private final PerfumeRepository perfumeRepository;

    public void update(Long id, Perfume updateParam){

        Perfume perfume = perfumeRepository.findById(id)
                .orElseThrow(()-> new GeneralException(ErrorStatus.PERFUME_NOT_FOUND));

        Perfume updatePerfume = PerfumeConverter.updatePerfume(perfume,updateParam);

        perfumeRepository.save(updatePerfume);

    }
}
