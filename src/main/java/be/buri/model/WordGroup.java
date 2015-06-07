package be.buri.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by buri on 2015. 6. 7..
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class WordGroup {

  @Id
  private String id;

  @Column
  private String name;

  @Column
  private String description;

}
