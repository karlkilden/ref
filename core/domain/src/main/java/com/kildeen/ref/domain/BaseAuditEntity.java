package com.kildeen.ref.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>File created: 2014-05-03 11:22</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
@MappedSuperclass
public class BaseAuditEntity extends BaseEntity {

    @Column(name = "revision")
    private int revision;

    @Column(name = "created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    private transient Date loadTime;

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

    @PostLoad
    protected void onLoad() {
        loadTime = new Date();
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(final int revision) {
        this.revision = revision;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(final Date loadTime) {
        this.loadTime = loadTime;
    }
}
