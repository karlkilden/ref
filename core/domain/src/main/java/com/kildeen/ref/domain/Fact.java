package com.kildeen.ref.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>File created: 2014-04-21 17:28</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Entity
@Table(name = "ref_fact")
public class Fact extends BaseAuditEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WordOccurrence> wordOccurrences = new ArrayList<>();

    public Fact(final String name) {
        this.name = name;
    }

    public Fact () {

    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<WordOccurrence> getWordOccurrences() {
        return wordOccurrences;
    }

    public void addWord(final WordOccurrence w) {
        wordOccurrences.add(w);
    }
}
