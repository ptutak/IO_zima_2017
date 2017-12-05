package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.ITaskManager;
import io2017.pierogimroku.task.api.ITaskView;
import io2017.pierogimroku.task.api.Task;
import io2017.pierogimroku.task.api.TaskNotFoundException;

import java.util.Date;
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
    public List<Task> searchTaskByAssignedEmployee(int employeeId) {
        System.err.println(TAG+": Searching Tasks by assigned employee "+ employeeId);
        List<Task> taskList = new LinkedList<>();
        taskList.add(new Task("Some Task",1,"Something", null, 10, employeeId, employeeId, 100));
        return taskList;
    }

    @Override
    public List<Task> search(String phrase) {
        System.err.println(TAG+": Searching Tasks by phrase "+phrase);
        List<Task> taskList = new LinkedList<>();
        taskList.add(new Task("Some Task",1,phrase, null, 10, 1, 1,100));
        return taskList;
    }

    @Override
    public List<Task> searchTaskByOwnerEmployee(int employeeId) {
        System.err.println(TAG+": Searching Tasks by owner id "+employeeId);
        List<Task> taskList = new LinkedList<>();
        taskList.add(new Task("Some Task",1,"Something", null, 10, employeeId, employeeId, 100));
        return taskList;
    }

    @Override
    public List<Task> getAll() {
        System.err.println(TAG+": Searching all Tasks");
        List<Task> taskList = new LinkedList<>();
        taskList.add(new Task("Some Task",1,"Something", null, 10, 1, 1, 100));
        return taskList;
    }

    @Override
    public int addTask(Task task) {
        System.err.println(TAG+": Task added " + task.toString());
        return task.getId();
    }

    @Override
    public void removeTask(int id) throws TaskNotFoundException {
        System.err.println(TAG+": Task removed " + id);
    }

    @Override
    public void editTask(Task task) throws TaskNotFoundException {
        System.err.println(TAG+": Task edited " + task.toString());
    }

    @Override
    public void assignToTask(int taskId, int assigneeId) throws TaskNotFoundException {
        System.err.println(TAG+": Task "+taskId+" assigned to "+assigneeId);
    }
}
