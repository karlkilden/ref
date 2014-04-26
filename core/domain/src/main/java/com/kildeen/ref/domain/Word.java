package com.kildeen.ref.domain;

import javax.persistence.*;
import java.util.List;

/**
 * <p>File created: 2014-04-24 21:13</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */

@Entity
@Table(name = "ref_word")
public class Word extends BaseEntity {

    @Column
    private boolean banned;

    @Column
    private String string;

    public String getString() {
        return string;
    }

    public void setString(final String string) {
        this.string = string;
    }
}
