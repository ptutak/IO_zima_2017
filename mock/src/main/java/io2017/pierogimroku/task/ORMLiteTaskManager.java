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
 * Implementation of task container
 */
public class ORMLiteTaskManager implements ITaskManager, ITaskView {

    @Override
    public int sum(int a, int b) {
        return 0;
    }

    @Override
    public List<Task> searchTaskByAssignedEmployee(int employeeId) {
        List<Task> taskList = new LinkedList<Task>();
        taskList.add(new Task("Some Task",1,"Something", null, 10, employeeId, employeeId, Task.Status.NEW, 100));
        return taskList;
    }

    @Override
    public List<Task> search(String phrase) {
        List<Task> taskList = new LinkedList<Task>();
        taskList.add(new Task("Some Task",1,phrase, null, 10, 1, 1, Task.Status.NEW, 100));
        return taskList;
    }

    @Override
    public List<Task> searchTaskByOwnerEmployee(int employeeId) {
        List<Task> taskList = new LinkedList<Task>();
        taskList.add(new Task("Some Task",1,"Something", null, 10, employeeId, employeeId, Task.Status.NEW, 100));
        return taskList;
    }

    @Override
    public List<Task> searchAll() {
        List<Task> taskList = new LinkedList<Task>();
        taskList.add(new Task("Some Task",1,"Something", null, 10, 1, 1, Task.Status.NEW, 100));
        return taskList;
    }

    @Override
    public int addTask(Task task) {
        System.err.println("Task added " + task.toString());
        return task.getId();
    }

    @Override
    public void removeTask(int id) throws TaskNotFoundException {
        System.err.println("Task removed " + id);
    }

    @Override
    public void editTask(Task task) throws TaskNotFoundException {
        System.err.println("Task edited " + task.toString());
    }
}
