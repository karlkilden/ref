package com.kildeen.ref.module.fact;

import java.io.Serializable;

/**
 * <p>File created: 2014-04-24 22:09</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class BaseDTO implements Serializable {

    private long id;
    private long version;

    public void setId(final long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

    public long getVersion() {
        return version;
    }
}
