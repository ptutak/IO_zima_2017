package io2017.pierogimroku.task.storage;

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
}
