package be.buri.controller;

import be.buri.model.Word;
import be.buri.repository.WordGroupRepository;
import be.buri.repository.WordRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CommonsLog
@RestController
@RequestMapping("/words")
public class WordController {

    @Autowired
    private WordRepository repo;


    @RequestMapping(method = RequestMethod.GET)
    public List<Word> findItems() {
      log.info(repo.findAll());
      return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Word addItem(@RequestBody Word word) {
        word.setId(null);
      return repo.save(word);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Word updateItem(@RequestBody Word updatedItem, @PathVariable String id) {
        updatedItem.setId(id);
      return repo.save(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable String id) {
        repo.delete(id);
    }
}
