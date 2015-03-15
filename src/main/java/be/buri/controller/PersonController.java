package be.buri.controller;

import be.buri.model.Item;
import be.buri.model.Person;
import be.buri.repository.PersonRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by buri on 2015. 3. 8..
 */
@RestController
@RequestMapping("/persons")
@CommonsLog
public class PersonController {

  @Autowired
  private PersonRepository repo;

  @RequestMapping(method = RequestMethod.POST)
  public Person addPerson(@RequestBody Person person) {
    return repo.save(person);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Person> findPersons() {
    return repo.findAll();
  }


}
