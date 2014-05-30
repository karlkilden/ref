package com.kildeen.ref.module.fact;

import java.util.Date;

/**
 * <p>File created: 2014-04-24 22:10</p>
 *
 * @version 1.0
 * @author: Karl Kildén
 * @since 1.0
 */
public class BaseAuditDTO extends BaseDTO {

    private String createdBy;

    private Date createdAt;

    private Date updatedAt;

    private transient Date loadTime;

    private int revision;

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

    public int getRevision() {
        return revision;
    }

    public void setRevision(final int revision) {
        this.revision = revision;
    }
}
