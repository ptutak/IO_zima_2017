package io2017.pierogimroku.task.api;

import java.util.Date;


/**
 * TaskLook represents a state of a Task at the query moment.
 */
public class TaskLook {
    /**
     * Status of the task
     */
    public enum Status{
        NEW,FINISHED,ASSIGNED,IN_REVIEW,UNDER_IMPLEMENTATION
    }


    private Integer id;
    private String name;
    private String description;
    private Integer ownerId;
    private Integer assignedId;
    private Date startDate;
    private Integer timeEstimate;
    private Integer priority;
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
     * Sets id of the task
     * @param id id to be set
     */
    public void setId(Integer id) {
        this.id = id;
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
    public Integer getTimeEstimate() {
        return timeEstimate;
    }

    /**
     * Sets time estimate
     * @param timeEstimate in hours
     */
    public void setTimeEstimate(Integer timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    /**
     * @return id of owner
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * Sets id of owner
     * @param ownerId owner id to be set
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return id of assigned employee
     */
    public Integer getAssignedId() {
        return assignedId;
    }

    /**
     * Assigns new employee
     * @param assignedId assignee id to be set
     */
    public void setAssignedId(Integer assignedId) {
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
    public Integer getPriority() {
        return priority;
    }

    /**
     * Changes priority of the task
     * @param priority new priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Creates empty task look
     */
    public TaskLook(){
        this.id=null;
        this.name=null;
        this.description=null;
        this.startDate=null;
        this.timeEstimate=null;
        this.ownerId=null;
        this.assignedId=null;
        this.status=null;
        this.priority=null;
    }

    /**
     * Creates empty task look with id
     * @param id id of a task
     */
    public TaskLook(Integer id){
        this.id=id;
        this.name=null;
        this.description=null;
        this.startDate=null;
        this.timeEstimate=null;
        this.ownerId=null;
        this.assignedId=null;
        this.status=null;
        this.priority=null;
    }

    /**
     * Creates empty task look with name
     * @param name name of a task
     */
    public TaskLook(String name){
        this.id=null;
        this.name=name;
        this.description=null;
        this.startDate=null;
        this.timeEstimate=null;
        this.ownerId=null;
        this.assignedId=null;
        this.status=null;
        this.priority=null;
    }

    /**
     * Creates empty task look with name, ownerId, STATUS NEW, TODAY's DATE
     * @param name name of a task
     * @param ownerId task owner id
     */
    public TaskLook(String name, Integer ownerId){
        this.id=null;
        this.name=name;
        this.ownerId=ownerId;
        this.description=null;
        this.startDate=null;
        this.timeEstimate=null;
        this.assignedId=null;
        this.status=Status.NEW;
        this.priority=null;
    }

    /**
     * Creates task look status NEW
     * @param name - title
     * @param id - database id
     * @param description description
     * @param startDate starting date
     * @param timeEstimate estimated time in hours
     * @param ownerId id of owner
     * @param assignedId id if employee assigned to the task
     * @param priority priority
     */
    public TaskLook(Integer id, String name, String description, Integer ownerId, Integer assignedId, Date startDate, Integer timeEstimate, Integer priority) {
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
     * Creates task look with Status NEW, without id
     * @param name - title
     * @param description description
     * @param startDate starting date
     * @param timeEstimate estimated time in hours
     * @param ownerId id of owner
     * @param assignedId id if employee assigned to the task
     * @param priority priority
     */
    public TaskLook(String name, String description, Integer ownerId, Integer assignedId, Date startDate, Integer timeEstimate, Integer priority) {
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
        return "TaskLook{" +
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
