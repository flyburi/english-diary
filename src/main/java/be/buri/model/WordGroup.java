package be.buri.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

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

  @DBRef
  private List<Word> words;


}
