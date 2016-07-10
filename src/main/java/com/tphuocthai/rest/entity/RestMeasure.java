package com.tphuocthai.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * RestMeasure entity
 * Created by tphuocthai on 7/9/16.
 */
@Entity
@JsonIgnoreProperties(value = { "new" })
public class RestMeasure extends AbstractPersistable<Long> {
    private String restMethodName;
    private String restMethod;
    private Long timeInMilliseconds;
    private Integer createdBy;
    private Long createdAt;
    private Integer lastUpdatedBy;
    private Long lastUpdatedAt;

    public String getRestMethodName() {
        return restMethodName;
    }

    public void setRestMethodName(String restMethodName) {
        this.restMethodName = restMethodName;
    }

    public String getRestMethod() {
        return restMethod;
    }

    public void setRestMethod(String restMethod) {
        this.restMethod = restMethod;
    }

    public Long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public void setTimeInMilliseconds(Long timeInMilliseconds) {
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
