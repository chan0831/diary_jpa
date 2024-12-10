package Diary.Propose.domain.perfume;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PerfumeRepository {

    private static final Map<Long, Perfume> store = new HashMap<>();

    private static long sequence = 0L;

    public Perfume save(Perfume perfume){
        perfume.setId(++sequence);
        store.put(perfume.getId(),perfume);
        return perfume;
    }

    public Perfume findById(Long id){
        return store.get(id);
    }

    public List<Perfume> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long perfumeId, Perfume updateParam){

        Perfume findPerfume = findById(perfumeId);
        findPerfume.setPerfumeName(updateParam.getPerfumeName());
        findPerfume.setBrand(updateParam.getBrand());
        findPerfume.setDate(updateParam.getDate());
        findPerfume.setRating(updateParam.getRating());
        findPerfume.setReview(updateParam.getReview());
        findPerfume.setBaseNote(updateParam.getBaseNote());
        findPerfume.setMiddleNote(updateParam.getMiddleNote());
        findPerfume.setTopNote(updateParam.getTopNote());
        findPerfume.setSeason(updateParam.getSeason());
        findPerfume.setAccords(updateParam.getAccords());
    }

    public void clearStore(){
        store.clear();
    }
}

