package Diary.Propose.domain.letter;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LetterRepository {

    private static final Map<Long, Letter> store = new HashMap<>();
    private static long sequence = 0L;

    public Letter save(Letter letter){
        letter.setId(++sequence);
        store.put(letter.getId(), letter);
        return letter;
    }

    public Letter findById(Long id){return store.get(id);}

    public List<Letter> findAll(){ return new ArrayList<>(store.values());
    }

    public void update(Long letterId, Letter updateParam){
        Letter findLetter = findById(letterId);
        findLetter.setTitle(updateParam.getTitle());
        findLetter.setDate(updateParam.getDate());
        findLetter.setDay(updateParam.getDay());
        findLetter.setContents(updateParam.getContents());

        findLetter.setLetterType(updateParam.getLetterType());
        findLetter.setScore(updateParam.getScore());
    }

    public void clearStore(){ store.clear();}
}
