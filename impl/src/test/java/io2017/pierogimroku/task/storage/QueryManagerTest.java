package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.ORMLiteTaskManager;
import io2017.pierogimroku.task.api.TaskContainerException;
import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.api.TaskNotFoundException;
import io2017.pierogimroku.task.storage.entity.Task;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class QueryManagerTest {

    @Test
    public void addAndRemoveTaskTest() throws SQLException, IOException {
        QueryManager queryManager = new QueryManager("build/tmp/addTaskTest");

        Task a = new Task();
        a.setName("TaskName");
        queryManager.addTask(a);

        assertTrue(queryManager.getAll().size()>0);

        queryManager.removeTask(a);
        assertTrue(queryManager.getAll().size()==0);
    }
    @Test
    public void test() throws TaskContainerException, TaskNotFoundException {
        ORMLiteTaskManager manager = new ORMLiteTaskManager("build/tmp/addTaskTest1k");

        TaskLook a = new TaskLook();
        a.setName("TaskName");
        int id = manager.addTask(a);

        assertTrue(manager.getAll().size()>0);
        TaskLook b = new TaskLook();
        b.setId(id);

        for(TaskLook taskLook: manager.getAll()){
            System.out.println(taskLook);
        }

        manager.removeTask(manager.searchTaskByLook(b).get(0));
        assertTrue(manager.searchTaskByLook(b).isEmpty());

    }

    @Test
    public void testIsStatusCorrect(){
        ORMLiteTaskManager manager = new ORMLiteTaskManager("build/tmp/addTaskTest1k");

        TaskLook a = new TaskLook();
        a.setName("TaskName");
        a.setStatus(TaskLook.Status.FINISHED);
        int id = manager.addTask(a);

        assertTrue(manager.getAll().size()>0);
        TaskLook b = new TaskLook();
        b.setId(id);

        assertTrue(manager.searchTaskByLook(b).get(0).getStatus().equals(TaskLook.Status.FINISHED));
    }
}
