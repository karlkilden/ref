package com.kildeen.ref.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <p>File created: 2014-04-24 21:41</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Entity
@Table(name = "ref_word_occurrence")
public class WordOccurrence extends BaseEntity {

    @Column
    private int index;

    @Column
    @ManyToOne(optional = false)
    private Word word;

    public WordOccurrence(final Word w, int i) {
        this.word = w;
        this.index = i;
    }

    public Word getWord() {
        return word;
    }
}
