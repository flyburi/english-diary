package be.buri.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Created by buri on 2015. 2. 15..
 */
@Setter
@Getter
public class Person {

  @Id private String id;

  private String firstName;
  private String lastName;


  public Person() {}

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

}