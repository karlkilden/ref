package com.kildeen.ref.domain;

import com.google.common.base.Strings;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * BaseUser: Karl Kildén
 * Date: 2013-11-19
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Column(name = "ref_created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ref_created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ref_latest_change_at")
    private Date latestChangeAt;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ref_readable_id")
    private String readableId;

    @Column(name = "ref_previous_readable_ids")
    private String previousReadableId;
    private transient List<String> previousReadableIds;

    public transient String readableIdAtRead;

    @Version
    private long version;

    private transient Date loadTime;

    protected String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getLatestChangeAt() {
        return latestChangeAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    protected Long getVersion() {
        return version;
    }

    public Object getObjectId() {
        return id;
    }

    @PreUpdate
    protected void onUpdate() {
        latestChangeAt = new Date();
        addPreviousId();
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        addPreviousId();
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
        readableIdAtRead = readableId;
        if (Strings.isNullOrEmpty(previousReadableId)) {
            // nothing to parse
        } else {
            String[] previous = previousReadableId.split(",");
            previousReadableIds = new ArrayList<>(Arrays.asList(previous));
        }

        loadTime = new Date();
    }

    private void addPreviousId() {

    }

}
