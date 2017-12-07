package io2017.pierogimroku.task.api;

import java.util.Date;


/**
 * TaskWrapper wrapper, represents results of database state in the moment of query
 */
public class TaskWrapper {
    /**
     * Status of the task
     */
    public enum Status{
        NEW,FINISHED,ASSIGNED,IN_REVIEW,UNDER_IMPLEMENTATION
    }
    private Integer id;
    private String name;
    private String description;
    private int ownerId;
    private int assignedId;
    private Date startDate;
    private int timeEstimate;
    private int priority;
    private Status status;



    /**
     * @return name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of the task
     * @param name name to be set
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
     * @param description description to be set
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
     * @param startDate start date to be set
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
     * @param ownerId owner id to be set
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
     * @param assignedId assignee id to be set
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
     * @param priority new priority
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
    public TaskWrapper(int id, String name, String description, int ownerId, int assignedId, Date startDate, int timeEstimate, int priority) {
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
    public TaskWrapper(String name, String description, int ownerId, int assignedId, Date startDate, int timeEstimate, int priority) {
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
        return "TaskWrapper{" +
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
