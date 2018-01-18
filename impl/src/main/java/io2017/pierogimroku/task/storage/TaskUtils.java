package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.storage.entity.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskUtils {

    private TaskUtils(){}

    public static Task transformTaskLook(TaskLook taskLook){
        Task t = new Task();
        t.setId(taskLook.getId());
        t.setAssignedId(taskLook.getAssignedId());
        t.setDescription(taskLook.getDescription());
        t.setName(taskLook.getName());
        t.setOwnerId(taskLook.getOwnerId());
        t.setPriority(taskLook.getPriority());
        t.setStartDate(taskLook.getStartDate());
        TaskLook.Status status=taskLook.getStatus();
        if (status!=null)
            switch(status){
                case NEW:
                    t.setStatus(Task.Status.NEW);
                    break;
                case FINISHED:
                    t.setStatus(Task.Status.FINISHED);
                    break;
                case ASSIGNED:
                    t.setStatus(Task.Status.ASSIGNED);
                    break;
                case UNDER_IMPLEMENTATION:
                    t.setStatus(Task.Status.UNDER_IMPLEMENTATION);
                    break;
                case IN_REVIEW:
                    t.setStatus(Task.Status.IN_REVIEW);
                    break;
            }
        else
            t.setStatus(null);

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

        Task.Status status=task.getStatus();

        if (status!=null)
            switch(status){
                case NEW:
                    taskLook.setStatus(TaskLook.Status.NEW);
                    break;
                case FINISHED:
                    taskLook.setStatus(TaskLook.Status.FINISHED);
                    break;
                case ASSIGNED:
                    taskLook.setStatus(TaskLook.Status.ASSIGNED);
                    break;
                case UNDER_IMPLEMENTATION:
                    taskLook.setStatus(TaskLook.Status.UNDER_IMPLEMENTATION);
                    break;
                case IN_REVIEW:
                    taskLook.setStatus(TaskLook.Status.IN_REVIEW);
                    break;
            }
        else
            taskLook.setStatus(null);

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
