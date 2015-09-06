package be.buri.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by buri on 2015. 1. 25..
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "id")
public class Word {
    @Id
    private String id;

    @Column
    private String en;

    @Column
    private String ko;

    @Column
    private boolean memorized;

    @Column
    private String wordGroupId;

    @Transient
    private String wordGroupName;

}
