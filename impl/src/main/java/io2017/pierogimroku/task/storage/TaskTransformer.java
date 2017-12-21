package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.storage.entity.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskTransformer {

    public static Task transformTaskWrapper(TaskLook wrapper){
        Task t = new Task();
        t.setId(wrapper.getId());
        t.setAssignedId(wrapper.getAssignedId());
        t.setDescription(wrapper.getDescription());
        t.setName(wrapper.getName());
        t.setOwnerId(wrapper.getOwnerId());
        t.setPriority(wrapper.getPriority());
        t.setStartDate(wrapper.getStartDate());
        t.setStatus(wrapper.getStatus());
        t.setTimeEstimate(wrapper.getTimeEstimate());
        return t;
    }

    public static TaskLook transformTask(Task task){
        TaskLook wrapper = new TaskLook(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getOwnerId(),
                task.getAssignedId(),
                task.getStartDate(),
                task.getTimeEstimate(),
                task.getPriority()
        );

        return wrapper;
    }

    public static List<TaskLook> transformTaskList(List<Task> taskList){
        List<TaskLook> taskLookList = new LinkedList<TaskLook>();
        for(Task task: taskList){
            taskLookList.add(transformTask(task));
        }
        return taskLookList;
    }

    public static List<Task> transformTaskWrapperList(List<TaskLook> taskLookList){
        List<Task> taskList = new LinkedList<Task>();
        for(TaskLook taskLook : taskLookList){
            taskList.add(transformTaskWrapper(taskLook));
        }
        return taskList;
    }
}
