package io2017.pierogimroku.task.api;

import java.util.Date;


/**
 * Task wrapper
 */
public class Task {
    /**
     * Status of the task
     */
    public enum Status{
        NEW,FINISHED,ASSIGNED,IN_REVIEW,UNDER_IMPLEMENTATION
    }
    private Integer id;
    private String name;
    private int ownerId;
    private int assignedId;
    private Date startDate;
    private int timeEstimate;
    private int priority;
    private Status status;
    private String description;


    /**
     * @return name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the task
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return database id of the task
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return start date of the task
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets start date
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return time estimate in hours
     */
    public int getTimeEstimate() {
        return timeEstimate;
    }

    /**
     * Sets time estimate
     * @param timeEstimate in hours
     */
    public void setTimeEstimate(int timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    /**
     * @return id of owner
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Sets id of owner
     * @param ownerId
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return id of assigned employee
     */
    public int getAssignedId() {
        return assignedId;
    }

    /**
     * Assigns new employee
     * @param assignedId
     */
    public void setAssignedId(int assignedId) {
        this.assignedId = assignedId;
    }


    /**
     * @return status of the task
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Changes status of the task
     * @param status new status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return priority of the task
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Changes priority of the task
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }


    /**
     * Creates task status NEW
     * @param name - title
     * @param id - database id
     * @param description description
     * @param startDate starting date
     * @param timeEstimate estimated time in hours
     * @param ownerId id of owner
     * @param assignedId id if employee assigned to the task
     * @param priority priority
     */
    public Task(int id, String name,int ownerId, int assignedId, Date startDate, int timeEstimate,  int priority,  String description) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.timeEstimate = timeEstimate;
        this.ownerId = ownerId;
        this.assignedId = assignedId;
        this.status = Status.NEW;
        this.priority = priority;

    }

    /**
     * Creates task with Status NEW, without id
     * @param name - title
     * @param description description
     * @param startDate starting date
     * @param timeEstimate estimated time in hours
     * @param ownerId id of owner
     * @param assignedId id if employee assigned to the task
     * @param priority priority
     */
    public Task(String name, String description, Date startDate, int timeEstimate, int ownerId, int assignedId, int priority) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.timeEstimate = timeEstimate;
        this.ownerId = ownerId;
        this.assignedId = assignedId;
        this.status = Status.NEW;
        this.priority = priority;
        this.id = null;
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
