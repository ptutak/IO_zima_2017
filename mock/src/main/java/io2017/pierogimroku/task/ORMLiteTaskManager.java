package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.ITaskManager;
import io2017.pierogimroku.task.api.ITaskView;
import io2017.pierogimroku.task.api.TaskWrapper;
import io2017.pierogimroku.task.api.TaskNotFoundException;

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
    public List<TaskWrapper> searchTaskByAssignedEmployee(int employeeId) {
        System.err.println(TAG+": Searching Tasks by assigned employee "+ employeeId);
        List<TaskWrapper> taskWrapperList = new LinkedList<>();
        taskWrapperList.add(new TaskWrapper("Some TaskWrapper","Something",10,1, null,  employeeId, 100));
        return taskWrapperList;
    }

    @Override
    public List<TaskWrapper> search(String phrase) {
        System.err.println(TAG+": Searching Tasks by phrase "+phrase);
        List<TaskWrapper> taskWrapperList = new LinkedList<>();
        taskWrapperList.add(new TaskWrapper("Some TaskWrapper",phrase,10,1, null,  1, 100));
        return taskWrapperList;
    }

    @Override
    public List<TaskWrapper> searchTaskByOwnerEmployee(int employeeId) {
        System.err.println(TAG+": Searching Tasks by owner id "+employeeId);
        List<TaskWrapper> taskWrapperList = new LinkedList<>();
        taskWrapperList.add(new TaskWrapper("Some TaskWrapper","Something",10,1, null,  employeeId, 100));
        return taskWrapperList;
    }

    @Override
    public List<TaskWrapper> getAll() {
        System.err.println(TAG+": Searching all Tasks");
        List<TaskWrapper> taskWrapperList = new LinkedList<>();
        taskWrapperList.add(new TaskWrapper("Some TaskWrapper","Something", 10, 1,null,  1, 100));
        return taskWrapperList;
    }

    @Override
    public int addTask(TaskWrapper taskWrapper) {
        System.err.println(TAG+": TaskWrapper added " + taskWrapper.toString());
        return taskWrapper.getId();
    }

    @Override
    public void removeTask(TaskWrapper taskWrapper) throws TaskNotFoundException {
        System.err.println(TAG+": TaskWrapper removed " + taskWrapper.getId());
    }

    @Override
    public void editTask(TaskWrapper taskWrapper) throws TaskNotFoundException {
        System.err.println(TAG+": TaskWrapper edited " + taskWrapper.toString());
    }

    @Override
    public void assignToTask(TaskWrapper taskWrapper) throws TaskNotFoundException {
        System.err.println(TAG+": TaskWrapper "+ taskWrapper.getId()+" assigned to "+ taskWrapper.getAssignedId());
    }
}
