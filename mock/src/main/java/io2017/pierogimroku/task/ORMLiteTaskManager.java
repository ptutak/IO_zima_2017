package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.*;

import java.util.LinkedList;
import java.util.List;

/*
 * Created by Pierogi Mroku, IO WIMiIP AGH 2017
 */

/**
 * Mock of task container, it should not be used in working product, soon to be deprecated <br>
 *     Uses System.err stream to log activity
 */
@Deprecated
public class ORMLiteTaskManager implements ITaskManager, ITaskView {

    private final String TAG = this.getClass().getName();

    @Override
    public List<TaskLook> searchTaskByAssignedEmployee(int employeeId) {
        System.err.println(TAG+": Searching Tasks by assigned employee "+ employeeId);
        List<TaskLook> taskLookList = new LinkedList<>();
        taskLookList.add(new TaskLook("Some TaskLook","Something",10,1, null,  employeeId, 100));
        return taskLookList;
    }

    @Override
    public List<TaskLook> searchTaskByLook(TaskLook taskLook) throws TaskContainerException {
        System.err.println(TAG+": Searching Tasks by task look "+ taskLook);
        List<TaskLook> taskLookList = new LinkedList<>();
        taskLookList.add(new TaskLook(taskLook.getName(),taskLook.getDescription(),taskLook.getOwnerId(),taskLook.getAssignedId(), taskLook.getStartDate(),  taskLook.getAssignedId(), taskLook.getPriority()));
        return taskLookList;
    }

    @Override
    public List<TaskLook> search(String phrase) {
        System.err.println(TAG+": Searching Tasks by phrase "+phrase);
        List<TaskLook> taskLookList = new LinkedList<>();
        taskLookList.add(new TaskLook("Some TaskLook",phrase,10,1, null,  1, 100));
        return taskLookList;
    }

    @Override
    public List<TaskLook> searchTaskByOwnerEmployee(int employeeId) {
        System.err.println(TAG+": Searching Tasks by owner id "+employeeId);
        List<TaskLook> taskLookList = new LinkedList<>();
        taskLookList.add(new TaskLook("Some TaskLook","Something",10,1, null,  employeeId, 100));
        return taskLookList;
    }

    @Override
    public List<TaskLook> getAll() {
        System.err.println(TAG+": Searching all Tasks");
        List<TaskLook> taskLookList = new LinkedList<>();
        taskLookList.add(new TaskLook("Some TaskLook","Something", 10, 1,null,  1, 100));
        return taskLookList;
    }

    @Override
    public int addTask(TaskLook taskLook) {
        System.err.println(TAG+": TaskLook added " + taskLook.toString());
        return taskLook.getId();
    }

    @Override
    public void removeTask(TaskLook taskLook) throws TaskNotFoundException {
        System.err.println(TAG+": TaskLook removed " + taskLook.getId());
    }

    @Override
    public void editTask(TaskLook taskLook) throws TaskNotFoundException {
        System.err.println(TAG+": TaskLook edited " + taskLook.toString());
    }

    @Override
    public void assignToTask(TaskLook taskLook) throws TaskNotFoundException {
        System.err.println(TAG+": TaskLook "+ taskLook.getId()+" assigned to "+ taskLook.getAssignedId());
    }
}
