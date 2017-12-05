package io2017.pierogimroku.task.api;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

import java.util.List;

/**
 * Provides functionality of retrieving tasks from task container/database
 */
public interface ITaskView {

    public List<Task> searchTaskByAssignedEmployee(int employeeId);
    public List<Task> search(String phrase);
    public List<Task> searchTaskByOwnerEmployee(int employeeId);
    public List<Task> searchAll();

}
