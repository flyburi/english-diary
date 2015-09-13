package be.buri;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by buri on 2015. 9. 8..
 */
@SpringBootApplication
@RestController
@CommonsLog
public class UiApplication {

  public static void main(String[] args) {
    SpringApplication.run(UiApplication.class, args);
  }

}