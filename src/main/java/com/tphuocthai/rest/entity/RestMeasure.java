package com.tphuocthai.rest.entity;

/**
 * RestMeasure entity
 * Created by tphuocthai on 7/9/16.
 */
public class RestMeasure {
    private Long id;
    private String restMethodName;
    private String restMethod;
    private Long timeInMiliseconds;
    private Integer createdBy;
    private Long createdAt;
    private Integer lastUpdatedBy;
    private Long lastUpdatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getTimeInMiliseconds() {
        return timeInMiliseconds;
    }

    public void setTimeInMiliseconds(Long timeInMiliseconds) {
        this.timeInMiliseconds = timeInMiliseconds;
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
