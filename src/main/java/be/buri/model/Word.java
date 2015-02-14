package be.buri.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by buri on 2015. 1. 25..
 */

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String en;

    @Column
    private String ko;

    @Column
    private boolean memorized;

}
