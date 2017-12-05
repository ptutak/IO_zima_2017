package io2017.pierogimroku.task.api;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

import java.util.List;

/**
 * Provides functionality of retrieving tasks from task container/database
 */
public interface ITaskView {

    /**
     * Searches and returns Task which are assigned to Employee with employeeId
     * @param employeeId id of Employee
     * @return List of tasks which are assigned to given Employee, list is empty if no task were found
     * @throws TaskContainerException on failure
     */
    public List<Task> searchTaskByAssignedEmployee(int employeeId) throws TaskContainerException;

    /**
     * Searches phrase everywhere
     * @param phrase string input
     * @return list of tasks with given phrase, list is empty if no task were found
     * @throws TaskContainerException on failure
     */
    public List<Task> search(String phrase) throws TaskContainerException;

    /**
     * Searches and returns Task which are owned by Employee with employeeId
     * @param employeeId id of Employee
     * @return List of tasks which are owned by given Employee, list is empty if no task were found
     * @throws TaskContainerException on failure
     */
    public List<Task> searchTaskByOwnerEmployee(int employeeId) throws TaskContainerException;

    /**
     * @return list of all tasks, list is empty if no task were found
     * @throws TaskContainerException on failure
     */
    public List<Task> getAll() throws TaskContainerException;

}
