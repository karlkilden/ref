package com.kildeen.ref.domain;

import org.apache.deltaspike.data.api.audit.ModifiedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * BaseUser: Karl Kildén
 * Date: 2013-11-19
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Version
    private long version;

    @Id
    @GeneratedValue
    private long id;

    public long getVersion() {
        return version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }
}
