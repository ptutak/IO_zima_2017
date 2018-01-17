package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.*;
import io2017.pierogimroku.task.storage.QueryManager;
import io2017.pierogimroku.task.storage.TaskUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ORMLiteTaskManager implements ITaskManager, ITaskView {
    private final String databaseName = "taskdatabase";
    private String tempDatabaseName=null;
    private QueryManager queryManager;


    public ORMLiteTaskManager() throws TaskContainerException{
        try {
            queryManager = new QueryManager(databaseName);
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        }
    }
    public ORMLiteTaskManager(String databaseName)throws TaskContainerException{
        try {
            queryManager = new QueryManager(databaseName);
            this.tempDatabaseName=databaseName;
        } catch(SQLException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public Integer addTask(TaskLook taskLook) throws TaskContainerException {
        taskLook.setId(null);
        try {
            int id = queryManager.addTask(TaskUtils.transformTaskLook(taskLook));
            taskLook.setId(id);
            return id;
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void removeTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.removeTask(TaskUtils.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskNotFoundException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void editTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.editTask(TaskUtils.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskNotFoundException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void assignToTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.assignToTask(TaskUtils.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskNotFoundException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> searchTaskByAssignedEmployee(int employeeId) throws TaskContainerException {
        try {
            return TaskUtils.transformTaskList(queryManager.searchTaskByAssignedEmployee(employeeId));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @java.lang.Override
    public List<TaskLook> searchTaskByLook(TaskLook taskLook) throws TaskContainerException {
        try {
            return TaskUtils.transformTaskList(queryManager.searchTask(TaskUtils.transformTaskLook(taskLook)));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> search(String phrase) throws TaskContainerException {
        try {
            return TaskUtils.transformTaskList(queryManager.search(phrase));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> searchTaskByOwnerEmployee(int employeeId) throws TaskContainerException {
        try {
            return TaskUtils.transformTaskList(queryManager.searchTaskByOwnerEmployee(employeeId));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> getAll() throws TaskContainerException {
        try {
            return TaskUtils.transformTaskList(queryManager.getAll());
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

}
