package be.buri.controller;

import be.buri.model.Word;
import be.buri.model.WordGroup;
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

    @Autowired
    private WordGroupRepository groupRepository;


    @RequestMapping(method = RequestMethod.GET)
    public List<Word> findItems() {
      log.info(repo.findAll());
      //TODO  change to VO
      List<Word> words = repo.findAll();
      WordGroup wordGroup = null;
      List<Word> result = new ArrayList<Word>();
      for(Word word : words){
        if(word.getWordGroupId() != null) {
          wordGroup = groupRepository.findOne(word.getWordGroupId());
          if(wordGroup != null)
            word.setWordGroupName(wordGroup.getName());
        }
        result.add(word);
      }
      return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Word addItem(@RequestBody Word word) {
      word.setId(null);
      log.info("등록 : " + word);
      word = repo.save(word);
      if (word.getWordGroupId() != null) {
        WordGroup wordGroup = groupRepository.findOne(word.getWordGroupId());
        if (wordGroup != null)
          word.setWordGroupName(wordGroup.getName());
      }
      return word;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Word updateItem(@RequestBody Word updatedItem, @PathVariable String id) {
        updatedItem.setId(id);
      log.debug("test");
      return repo.save(updatedItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable String id) {
        repo.delete(id);
    }
}
