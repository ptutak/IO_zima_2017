package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.*;
import io2017.pierogimroku.task.storage.QueryManager;
import io2017.pierogimroku.task.storage.TaskTransformer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ORMLiteTaskManager implements ITaskManager, ITaskView {
    private final String databaseName = "taskdatabase";
    private QueryManager queryManager;

    public ORMLiteTaskManager() throws TaskContainerException{
        try {
            queryManager = new QueryManager(databaseName);
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public int addTask(TaskWrapper taskWrapper) throws TaskContainerException {
        try {
            return queryManager.addTask(TaskTransformer.transformTaskWrapper(taskWrapper));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void removeTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.removeTask(TaskTransformer.transformTaskWrapper(taskWrapper));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void editTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.editTask(TaskTransformer.transformTaskWrapper(taskWrapper));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void assignToTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.assignToTask(TaskTransformer.transformTaskWrapper(taskWrapper));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskWrapper> searchTaskByAssignedEmployee(int employeeId) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.searchTaskByAssignedEmployee(employeeId));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskWrapper> search(String phrase) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.search(phrase));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskWrapper> searchTaskByOwnerEmployee(int employeeId) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.searchTaskByOwnerEmployee(employeeId));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskWrapper> getAll() throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.getAll());
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }
}
