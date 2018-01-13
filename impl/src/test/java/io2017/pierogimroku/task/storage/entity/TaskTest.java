package io2017.pierogimroku.task.storage.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kuba on 12.01.2018.
 */
public class TaskTest {
    @Test
    public void testToString() {
        //given
        Task task = new Task();

        //when
        task.setName("abcd");

        //then
        assertEquals(task.toString(),
                "Task{name='abcd', id=null, description='null', startDate=null, timeEstimate=null, ownerId=null, assignedId=null, status=null, priority=null}");
    }
}
