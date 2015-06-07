package be.buri.controller;

import be.buri.model.Word;
import be.buri.model.WordGroup;
import be.buri.repository.WordGroupRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by buri on 2015. 6. 7..
 */
@RestController
@RequestMapping("/wordGroups")
@CommonsLog
public class WordGroupController {

  @Autowired
  private WordGroupRepository repo;

  @RequestMapping(method = RequestMethod.GET)
  public List<WordGroup> findItems() {
    log.info(repo.findAll());
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public WordGroup addItem(@RequestBody WordGroup wordGroup) {
    wordGroup.setId(null);
    return repo.save(wordGroup);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public WordGroup updateItem(@RequestBody WordGroup updatedItem, @PathVariable String id) {
    updatedItem.setId(id);
    return repo.save(updatedItem);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable String id) {
    repo.delete(id);
  }
}
