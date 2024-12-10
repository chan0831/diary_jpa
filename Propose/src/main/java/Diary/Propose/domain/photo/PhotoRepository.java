package Diary.Propose.domain.photo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PhotoRepository {

    private final Map<Long, Photo> store = new HashMap<>();

    private long sequence = 0L;

    public Photo save(Photo photo){
        photo.setId(++sequence);
        store.put(photo.getId(), photo);
        return photo;
    }

    public Photo findById(Long id){
        return store.get(id);
    }
}
