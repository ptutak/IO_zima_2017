package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.storage.entity.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskTransformer {


    public static Task transformTaskLook(TaskLook taskLook){
        Task t = new Task();
        t.setId(taskLook.getId());
        t.setAssignedId(taskLook.getAssignedId());
        t.setDescription(taskLook.getDescription());
        t.setName(taskLook.getName());
        t.setOwnerId(taskLook.getOwnerId());
        t.setPriority(taskLook.getPriority());
        t.setStartDate(taskLook.getStartDate());
        t.setStatus(taskLook.getStatus());
        t.setTimeEstimate(taskLook.getTimeEstimate());
        return t;
    }

    public static TaskLook transformTask(Task task){
        TaskLook taskLook = new TaskLook(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getOwnerId(),
                task.getAssignedId(),
                task.getStartDate(),
                task.getTimeEstimate(),
                task.getPriority()
        );

        return taskLook;
    }

    public static List<TaskLook> transformTaskList(List<Task> taskList){
        List<TaskLook> taskLookList = new LinkedList<TaskLook>();
        for(Task task: taskList){
            taskLookList.add(transformTask(task));
        }
        return taskLookList;
    }

    public static List<Task> transformTaskLookList(List<TaskLook> taskLookList){
        List<Task> taskList = new LinkedList<Task>();
        for(TaskLook taskLook : taskLookList){
            taskList.add(transformTaskLook(taskLook));
        }
        return taskList;
    }
}
