package io2017.pierogimroku.task.storage.entity;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;


public class TaskTest {

    @Test
    public void testTaskConstructor(){
        Task task=new Task();

        assertNotNull(task);
    }

    @Test
    public void testSetAndGet() throws ParseException {

        Task task = new Task();

        String oldstring = "2011-01-18";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);

        task.setName("testToString");
        task.setId(1);
        task.setDescription("testToString");
        task.setStartDate(date);
        task.setTimeEstimate(30);
        task.setOwnerId(2);
        task.setAssignedId(3);
        task.setStatus(Task.Status.NEW);
        task.setPriority(0);

        assertTrue(task.getName().equals("testToString"));
        assertTrue(task.getId().equals(1));
        assertTrue(task.getDescription().equals("testToString"));
        assertTrue(task.getStartDate().equals(date));
        assertTrue(task.getTimeEstimate().equals(30));
        assertTrue(task.getOwnerId().equals(2));
        assertTrue(task.getAssignedId().equals(3));
        assertTrue(task.getStatus().equals(Task.Status.NEW));
        assertTrue(task.getPriority().equals(0));
    }

    @Test
    public void testToString() throws ParseException {

        Task task = new Task();

        String oldstring = "2011-01-18";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);

        task.setName("testToString");
        task.setId(1);
        task.setDescription("testToString");
        task.setStartDate(date);
        task.setTimeEstimate(30);
        task.setOwnerId(2);
        task.setAssignedId(3);
        task.setStatus(Task.Status.NEW);
        task.setPriority(0);

        assertEquals(task.toString(),
                "Task{name='testToString', id=1, description='testToString', startDate=Tue Jan 18 00:00:00 CET 2011, timeEstimate=30, ownerId=2, assignedId=3, status=NEW, priority=0}");
    }
}
