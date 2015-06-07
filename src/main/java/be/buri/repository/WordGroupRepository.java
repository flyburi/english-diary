package be.buri.repository;

import be.buri.model.WordGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by buri on 2015. 6. 7..
 */
public interface WordGroupRepository extends MongoRepository<WordGroup, String> {
}
