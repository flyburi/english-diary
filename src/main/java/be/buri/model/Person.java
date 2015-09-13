package be.buri.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

/**
 * Created by buri on 2015. 2. 15..
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

  @Id private String id;

  private String firstName;
  private String lastName;
  @Column
  private String nickName;
  @Column
  private String password;
  @Column
  private String email;



}