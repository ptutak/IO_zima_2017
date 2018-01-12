package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.storage.entity.Task;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kuba on 12.01.2018.
 */
public class TaskTransformerTest {
    @Test
    public void transformTaskLook() {
        //given
        TaskLook taskLook = new TaskLook(1, "name", "description", 2, 3, new Date(), 4, 5);

        //when
        Task task = TaskTransformer.transformTaskLook(taskLook);

        //then
        assertEquals(task.getId(), taskLook.getId());
        assertEquals(task.getName(), taskLook.getName());
        assertEquals(task.getDescription(), taskLook.getDescription());
        assertEquals(task.getOwnerId(), taskLook.getOwnerId());
        assertEquals(task.getAssignedId(), taskLook.getAssignedId());
        assertEquals(task.getStartDate(), taskLook.getStartDate());
        assertEquals(task.getTimeEstimate(), taskLook.getTimeEstimate());
        assertEquals(task.getPriority(), taskLook.getPriority());
    }

    @Test
    public void transformTask() {
        //given
        Task task = new Task();
        task.setAssignedId(1);
        task.setDescription("description");
        task.setId(2);
        task.setName("name");
        task.setOwnerId(3);
        task.setPriority(4);
        task.setTimeEstimate(5);
        task.setStartDate(new Date(2015,10,20));
        task.setStatus(TaskLook.Status.ASSIGNED);

        //when
        TaskLook taskLook = TaskTransformer.transformTask(task);

        //then
        assertEquals(task.getId(), taskLook.getId());
        assertEquals(task.getName(), taskLook.getName());
        assertEquals(task.getDescription(), taskLook.getDescription());
        assertEquals(task.getOwnerId(), taskLook.getOwnerId());
        assertEquals(task.getAssignedId(), taskLook.getAssignedId());
        assertEquals(task.getStartDate(), taskLook.getStartDate());
        assertEquals(task.getTimeEstimate(), taskLook.getTimeEstimate());
        assertEquals(task.getPriority(), taskLook.getPriority());

    }

    @Test
    public void transformTaskList() {
        //given
        List<Task> tasks = Arrays.asList(new Task(), new Task(), new Task());

        //when
        List<TaskLook> taskLooks = TaskTransformer.transformTaskList(tasks);

        //then
        assertEquals(3, taskLooks.size());
    }

    @Test
    public void transformTaskLookList() {
        //given
        List<TaskLook> taskLooks = Arrays.asList(new TaskLook(), new TaskLook(), new TaskLook(), new TaskLook());

        //when
        List<Task> tasks = TaskTransformer.transformTaskLookList(taskLooks);

        //then
        assertEquals(4, tasks.size());
    }
}
