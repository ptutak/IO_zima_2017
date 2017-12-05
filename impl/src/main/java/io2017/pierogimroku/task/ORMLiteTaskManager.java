package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.*;

import java.util.List;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

/**
 * Implementation of task container
 */
public class ORMLiteTaskManager implements ITaskManager, ITaskView {


    @Override
    public int addTask(Task task) throws TaskContainerException {
        return 0;
    }

    @Override
    public void removeTask(int id) throws TaskContainerException {

    }

    @Override
    public void editTask(Task task) throws TaskContainerException {

    }

    @Override
    public void assignToTask(int taskId, int assigneeId) throws TaskContainerException {

    }

    @Override
    public List<Task> searchTaskByAssignedEmployee(int employeeId) throws TaskContainerException {
        return null;
    }

    @Override
    public List<Task> search(String phrase) throws TaskContainerException {
        return null;
    }

    @Override
    public List<Task> searchTaskByOwnerEmployee(int employeeId) throws TaskContainerException {
        return null;
    }

    @Override
    public List<Task> getAll() throws TaskContainerException {
        return null;
    }
}
