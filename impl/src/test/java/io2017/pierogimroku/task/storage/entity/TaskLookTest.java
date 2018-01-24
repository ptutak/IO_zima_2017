package io2017.pierogimroku.task.storage.entity;

import io2017.pierogimroku.task.api.TaskLook;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;



public class TaskLookTest
{
    @Test
    public void testTaskLookDefaultConstructor()
    {

        TaskLook task1 = new TaskLook();
        assertTrue(task1.getId()==null);
        assertTrue(task1.getName()==null);
        assertTrue(task1.getDescription()==null);
        assertTrue(task1.getOwnerId()==null);
        assertTrue(task1.getAssignedId()==null);
        assertTrue(task1.getStartDate()==null);
        assertTrue(task1.getTimeEstimate()==null);
        assertTrue(task1.getPriority()==null);
        assertTrue(task1.getStatus()==null);

    }

    @Test
    public void testTaskLookConstructorId()
    {
        Integer id=5;
        TaskLook taskLook = new TaskLook(id);

        assertTrue(taskLook.getId()==id);
        assertTrue(taskLook.getName()==null);
        assertTrue(taskLook.getDescription()==null);
        assertTrue(taskLook.getOwnerId()==null);
        assertTrue(taskLook.getAssignedId()==null);
        assertTrue(taskLook.getStartDate()==null);
        assertTrue(taskLook.getTimeEstimate()==null);
        assertTrue(taskLook.getPriority()==null);
        assertTrue(taskLook.getStatus()==null);

    }

    @Test
    public void testTaskLookConstructorName()
    {
        String name="Nazwa";
        TaskLook taskLook = new TaskLook(name);

        assertTrue(taskLook.getId()==null);
        assertTrue(taskLook.getName()==name);
        assertTrue(taskLook.getDescription()==null);
        assertTrue(taskLook.getOwnerId()==null);
        assertTrue(taskLook.getAssignedId()==null);
        assertTrue(taskLook.getStartDate()==null);
        assertTrue(taskLook.getTimeEstimate()==null);
        assertTrue(taskLook.getPriority()==null);
        assertTrue(taskLook.getStatus()==null);
    }

    @Test
    public void testTaskLookConstructorNameOwnerId()
    {
        String name="Nazwa";
        Integer ownerId=2;
        TaskLook taskLook = new TaskLook(name,ownerId);
        Date startDate=taskLook.getStartDate();


        assertTrue(taskLook.getId()==null);
        assertTrue(taskLook.getName()==name);
        assertTrue(taskLook.getDescription()==null);
        assertTrue(taskLook.getOwnerId()==ownerId);
        assertTrue(taskLook.getAssignedId()==null);
        assertTrue(taskLook.getStartDate()==startDate);
        assertTrue(taskLook.getTimeEstimate()==null);
        assertTrue(taskLook.getPriority()==null);
        assertTrue(taskLook.getStatus()== TaskLook.Status.NEW);
    }

    @Test
    public void testTaskLookConstructor() {
        Integer id = 5;
        String name = "Nazwa";
        String description = "Opis";
        Integer ownerId = 2;
        Integer assignedId = 1;
        Date startDate = new Date(10);
        Integer timeEstimate = 100;
        Integer priority = 1;
        TaskLook.Status status = TaskLook.Status.FINISHED;
        TaskLook taskLook = new TaskLook(id, name, description, ownerId, assignedId, startDate, timeEstimate, priority);

        assertTrue(taskLook.getId() == id);
        assertTrue(taskLook.getName() == name);
        assertTrue(taskLook.getDescription() == description);
        assertTrue(taskLook.getOwnerId() == ownerId);
        assertTrue(taskLook.getAssignedId() == assignedId);
        assertTrue(taskLook.getStartDate() == startDate);
        assertTrue(taskLook.getTimeEstimate() == timeEstimate);
        assertTrue(taskLook.getPriority() == priority);
        assertTrue(taskLook.getStatus() == TaskLook.Status.NEW);
    }

    @Test
    public void testTaskLookConstructorNoId() {
        String name = "Nazwa";
        String description = "Opis";
        Integer ownerId = 2;
        Integer assignedId = 1;
        Date startDate = new Date(10);
        Integer timeEstimate = 100;
        Integer priority = 1;
        TaskLook.Status status = TaskLook.Status.FINISHED;
        TaskLook taskLook = new TaskLook(name, description, ownerId, assignedId, startDate, timeEstimate, priority);

        assertTrue(taskLook.getId() == null);
        assertTrue(taskLook.getName() == name);
        assertTrue(taskLook.getDescription() == description);
        assertTrue(taskLook.getOwnerId() == ownerId);
        assertTrue(taskLook.getAssignedId() == assignedId);
        assertTrue(taskLook.getStartDate() == startDate);
        assertTrue(taskLook.getTimeEstimate() == timeEstimate);
        assertTrue(taskLook.getPriority() == priority);
        assertTrue(taskLook.getStatus() == TaskLook.Status.NEW);
    }

    @Test
    public void testTaskLookStatus()
    {
        TaskLook task = new TaskLook();
        task.setStatus(TaskLook.Status.NEW);
        assertTrue(task.getStatus() == TaskLook.Status.NEW);
        task.setStatus(TaskLook.Status.ASSIGNED);
        assertTrue(task.getStatus() == TaskLook.Status.ASSIGNED);
        task.setStatus(TaskLook.Status.IN_REVIEW);
        assertTrue(task.getStatus() == TaskLook.Status.IN_REVIEW);
        task.setStatus(TaskLook.Status.FINISHED);
        assertTrue(task.getStatus() == TaskLook.Status.FINISHED);
        task.setStatus(TaskLook.Status.UNDER_IMPLEMENTATION);
        assertTrue(task.getStatus() == TaskLook.Status.UNDER_IMPLEMENTATION);
    }


}
