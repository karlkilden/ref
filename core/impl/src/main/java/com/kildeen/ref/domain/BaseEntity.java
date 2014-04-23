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

    @ModifiedBy
    @Column(name = "ref_created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ref_created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ref_latest_change_at")
    private Date updatedAt;

    @Id
    @GeneratedValue
    @Column(name = "ref_id")
    private long id;

    @Column(name = "ref_revision")
    private int revision;

    @Version
    private long version;

    @Column(name = "ref_readable_id")
    private String readableId;

    private transient Date loadTime;

    protected String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public long getId() {
        return id;
    }

    protected long getVersion() {
        return version;
    }


    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
        revision++;
    }

    @PrePersist
    protected void onCreate() {
        revision++;
        createdAt = new Date();
    }

    public String getReadableId() {
        return readableId;
    }

    protected void setReadableId(String readableId) {
        this.readableId = readableId;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    @PostLoad
    protected void onLoad() {
        loadTime = new Date();
    }

}
