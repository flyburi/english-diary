package be.buri.repository;

import be.buri.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by buri on 2015. 2. 15..
 */
public interface PersonRepository extends MongoRepository<Person, String> {

  public Person findByFirstName(String firstName);
  public List<Person> findByLastName(String lastName);

}