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


    public static void main(String[] argv){
        ORMLiteTaskManager a = null;
        try {
            a = new ORMLiteTaskManager();
        } catch (TaskContainerException e) {
            e.printStackTrace();
        }
        try {
            a.addTask(new TaskLook("asd","asdasd",1,2,null,1,2));
        } catch (TaskContainerException e) {
            e.printStackTrace();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ORMLiteTaskManager() throws TaskContainerException{
        try {
            queryManager = new QueryManager(databaseName);
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public int addTask(TaskLook taskLook) throws TaskContainerException {
        try {
            return queryManager.addTask(TaskTransformer.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void removeTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.removeTask(TaskTransformer.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void editTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.editTask(TaskTransformer.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public void assignToTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException {
        try {
            queryManager.assignToTask(TaskTransformer.transformTaskLook(taskLook));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> searchTaskByAssignedEmployee(int employeeId) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.searchTaskByAssignedEmployee(employeeId));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @java.lang.Override
    public List<TaskLook> searchTaskByLook(TaskLook taskLook) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.searchTask(taskLook));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> search(String phrase) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.search(phrase));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> searchTaskByOwnerEmployee(int employeeId) throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.searchTaskByOwnerEmployee(employeeId));
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

    @Override
    public List<TaskLook> getAll() throws TaskContainerException {
        try {
            return TaskTransformer.transformTaskList(queryManager.getAll());
        } catch (SQLException e) {
            throw new TaskContainerException(e);
        } catch (IOException e) {
            throw new TaskContainerException(e);
        }
    }

}
