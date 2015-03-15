package be.buri.repository;

import be.buri.model.Word;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WordRepository extends MongoRepository<Word, String> {
  public Word findByMemorized(boolean memorized);
  public List<Word> findAllByMemorized(boolean memorized);
}
