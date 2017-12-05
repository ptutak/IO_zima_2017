package io2017.pierogimroku.task.api;

import java.util.Date;

public class Task {
    public enum Status{
        NEW,FINISHED,ASSIGNED,IN_REVIEW,UNDER_IMPLEMENTATION
    }
    private String name;
    private Integer id;
    private String description;
    private Date startDate;
    private int timeEstimate;
    private int ownerId;
    private int assignedId;
    private Status status;
    private int priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(int timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(int assignedId) {
        this.assignedId = assignedId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Task(String name, int id, String description, Date startDate, int timeEstimate, int ownerId, int assignedId, Status status, int priority) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.timeEstimate = timeEstimate;
        this.ownerId = ownerId;
        this.assignedId = assignedId;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", timeEstimate=" + timeEstimate +
                ", ownerId=" + ownerId +
                ", assignedId=" + assignedId +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
