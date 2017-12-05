package io2017.pierogimroku.task.api;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

/**
 * Provides management functionality to task container/database
 */
public interface ITaskManager {

    /**
     * Add task, id parameter in Task wrapper is ignored
     * @param task
     * @return id of the task
     * @throws TaskContainerException on failure
     */
    int addTask(Task task) throws TaskContainerException;

    /**
     * Removes task
     * @param id of task to remove
     * @throws TaskNotFoundException where there is no task with given id
     * @throws TaskContainerException on failure
     */
    void removeTask(int id) throws  TaskContainerException;

    /**
     * Edits task
     * @param task - new task to be replaced, Task id should be set
     * @throws TaskNotFoundException where there is no task with given id
     * @throws TaskContainerException on failure
     */
    void editTask(Task task) throws TaskContainerException;

    /**
     * Assigns employee to task
     * @param taskId id of task
     * @param assigneeId id of employee
     * @throws TaskNotFoundException where there is no task with given id
     * @throws TaskContainerException on failure
     */
    void assignToTask(int taskId, int assigneeId) throws TaskContainerException;
}
