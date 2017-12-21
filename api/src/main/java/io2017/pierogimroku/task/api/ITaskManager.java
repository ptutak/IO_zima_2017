package io2017.pierogimroku.task.api;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

/**
 * Provides management functionality to task container/database
 */
public interface ITaskManager {

    /**
     * Add taskLook, id parameter in TaskLook wrapper is ignored
     * @param taskLook wrapped task data
     * @return id of the taskLook
     * @throws TaskContainerException on failure
     */
    int addTask(TaskLook taskLook) throws TaskContainerException;

    /**
     * Removes task
     * @param taskLook wrapped task data
     * @throws TaskContainerException on failure
     * @throws TaskNotFoundException when task is not found
     */
    void removeTask(TaskLook taskLook) throws  TaskContainerException, TaskNotFoundException;

    /**
     * Edits taskLook
     * @param taskLook - new taskLook to be replaced, TaskLook id should be set
     * @throws TaskNotFoundException where there is no taskLook with given id
     * @throws TaskContainerException on failure
     */
    void editTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException;

    /**
     * Assigns employee to task. It will only update the task parameter in storage.
     * @param taskLook wrapped task data
     * @throws TaskNotFoundException where there is no task with given id
     * @throws TaskContainerException on failure
     */
    void assignToTask(TaskLook taskLook) throws TaskContainerException, TaskNotFoundException;
}
