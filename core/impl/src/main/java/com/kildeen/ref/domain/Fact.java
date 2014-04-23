package com.kildeen.ref.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>File created: 2014-04-21 17:28</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@Entity
@NamedQuery(name="byName",
        query="SELECT fact FROM Fact fact WHERE fact.name = :name")
public class Fact extends BaseEntity {

    @Column(name = "ref_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
