package io2017.pierogimroku.task.api;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

/**
 * Provides management functionality to task container/database
 */
public interface ITaskManager {

    /**
     * Add taskWrapper, id parameter in TaskWrapper wrapper is ignored
     * @param taskWrapper wrapped task data
     * @return id of the taskWrapper
     * @throws TaskContainerException on failure
     */
    int addTask(TaskWrapper taskWrapper) throws TaskContainerException;

    /**
     * Removes task
     * @param taskWrapper wrapped task data
     * @throws TaskContainerException on failure
     * @throws TaskNotFoundException when task is not found
     */
    void removeTask(TaskWrapper taskWrapper) throws  TaskContainerException, TaskNotFoundException;

    /**
     * Edits taskWrapper
     * @param taskWrapper - new taskWrapper to be replaced, TaskWrapper id should be set
     * @throws TaskNotFoundException where there is no taskWrapper with given id
     * @throws TaskContainerException on failure
     */
    void editTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException;

    /**
     * Assigns employee to task. It will only update the task parameter in storage.
     * @param taskWrapper wrapped task data
     * @throws TaskNotFoundException where there is no task with given id
     * @throws TaskContainerException on failure
     */
    void assignToTask(TaskWrapper taskWrapper) throws TaskContainerException, TaskNotFoundException;
}
