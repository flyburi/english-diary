package be.buri.controller;

import be.buri.model.Word;
import be.buri.repository.WordRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CommonsLog
@RestController
@RequestMapping("/quiz")
public class QuizController {

  @Autowired
  private WordRepository repo;

  @RequestMapping(method = RequestMethod.GET)
  public List<Word> findByMemorized() {
    return repo.findAllByMemorized(false);
  }
  /*
    @RequestMapping(method = RequestMethod.GET)
    public Word getOne(){ //TODO paging
      log.info("any.  : " + repo.findByMemorized(false));
      return repo.findByMemorized(false);
    }
    */
}
