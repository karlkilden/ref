package com.kildeen.ref.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
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


    public String baseToString() {
        return " id: " + id;
    }

    /**
     * @param other entity
     * @return True if the id is equal. Null if both entites are new.
     */
    public Boolean baseEquals(BaseEntity other) {

        long otherId = other.getId();
        long id = this.getId();

        if (id == otherId && id != 0) {
            return true;
        } else if (id == 0 && otherId == 0) {
            return null;
        } else {
            return false;
        }
    }

    /**
     *
     * @param other entity
     * @param comparablePairs Values to be compared for equality. Ordered like this: Left side[0], right side[1]
     *                        {@link java.lang.ArrayIndexOutOfBoundsException} will be thrown if a right side is missing.
     * @return
     */
    public Boolean baseEquals(BaseEntity other, Object... comparablePairs) {
        Boolean equal = baseEquals(other);

        if (equal == null) {
            EqualsBuilder eb = new EqualsBuilder();
            int i = 0;
            while (i < comparablePairs.length - 1) {
                eb.append(comparablePairs[i++], comparablePairs[i++]);
            }

            equal = eb.build();

        }
        return equal;
    }
}
