package io2017.pierogimroku.task.storage.entity;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import io2017.pierogimroku.task.api.TaskWrapper;

@DatabaseTable(tableName = "tasks")
public class Task {
    public static final String ID = "id";
    @DatabaseField(columnName = ID, generatedId=true)
    private Integer id;

    public static final String NAME = "name";
    @DatabaseField(columnName = "name")
    private String name;

    public static final String DESCRIPTION = "description";
    @DatabaseField(columnName = DESCRIPTION)
    private String description;

    public static final String OWNERID = "ownerId";
    @DatabaseField(columnName = OWNERID)
    private Integer ownerId;

    public static final String ASSIGNEDID = "assignedId";
    @DatabaseField(columnName = ASSIGNEDID)
    private Integer assignedId;

    public static final String STARTDATE = "startdate";
    @DatabaseField(columnName = STARTDATE)
    private Date startDate;

    public static final String TIMEESTIMATE = "timeEstimate";
    @DatabaseField(columnName = TIMEESTIMATE)
    private Integer timeEstimate;

    public static final String PRIORITY = "priority";
    @DatabaseField(columnName = PRIORITY)
    private Integer priority;

    public static final String STATUS = "status";
    @DatabaseField(columnName = STATUS)
    private TaskWrapper.Status status;

    public Task() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(Integer assignedId) {
        this.assignedId = assignedId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getTimeEstimate() {
        return timeEstimate;
    }

    public void setTimeEstimate(Integer timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public TaskWrapper.Status getStatus() {
        return status;
    }

    public void setStatus(TaskWrapper.Status status) {
        this.status = status;
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