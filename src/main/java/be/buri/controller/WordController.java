package be.buri.controller;

import be.buri.model.Word;
import be.buri.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/words")
public class WordController {

    @Autowired
    private WordRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Word> findItems() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Word addItem(@RequestBody Word word) {
        word.setId(null);
        return repo.saveAndFlush(word);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Word updateItem(@RequestBody Word updatedItem, @PathVariable Integer id) {
        updatedItem.setId(id);
        return repo.saveAndFlush(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id) {
        repo.delete(id);
    }
}
