package org.kizilay.yusuf.caveatemptor.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDomain {

    @Version
    protected Long version;

    @CreatedDate
    @Column(name = "CREATION_TIME", nullable = false, insertable = true, updatable = false)
    protected Timestamp creationTime;

    @LastModifiedDate
    @Column(name = "UPDATED_TIME", nullable = false)
    protected Timestamp updatedTime;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }
}
