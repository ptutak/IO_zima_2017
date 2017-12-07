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
    public int addTask(TaskWrapper taskWrapper) throws TaskContainerException {
        return 0;
    }

    @Override
    public void removeTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException {

    }

    @Override
    public void editTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException {

    }

    @Override
    public void assignToTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException {

    }

    @Override
    public List<TaskWrapper> searchTaskByAssignedEmployee(int employeeId) throws TaskContainerException {
        return null;
    }

    @Override
    public List<TaskWrapper> search(String phrase) throws TaskContainerException {
        return null;
    }

    @Override
    public List<TaskWrapper> searchTaskByOwnerEmployee(int employeeId) throws TaskContainerException {
        return null;
    }

    @Override
    public List<TaskWrapper> getAll() throws TaskContainerException {
        return null;
    }
}
