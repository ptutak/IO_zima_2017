package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.api.TaskWrapper;
import io2017.pierogimroku.task.storage.entity.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskTransformer {

    public static Task transformTaskWrapper(TaskWrapper wrapper){
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

    public static TaskWrapper transformTask(Task task){
        TaskWrapper wrapper = new TaskWrapper(
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

    public static List<TaskWrapper> transformTaskList(List<Task> taskList){
        List<TaskWrapper> taskWrapperList = new LinkedList<TaskWrapper>();
        for(Task task: taskList){
            taskWrapperList.add(transformTask(task));
        }
        return taskWrapperList;
    }

    public static List<Task> transformTaskWrapperList(List<TaskWrapper> taskWrapperList){
        List<Task> taskList = new LinkedList<Task>();
        for(TaskWrapper taskWrapper: taskWrapperList){
            taskList.add(transformTaskWrapper(taskWrapper));
        }
        return taskList;
    }
}
