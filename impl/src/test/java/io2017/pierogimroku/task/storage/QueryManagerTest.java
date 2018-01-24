package io2017.pierogimroku.task.storage;

import io2017.pierogimroku.task.api.TaskNotFoundException;
import io2017.pierogimroku.task.storage.entity.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueryManagerTest {
    private QueryManager manager;

    @Before
    public void setup() {
        try {
            manager = new QueryManager("build/tmp/addTaskTest2k");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfExceptionThrownOnNotExistingTaskWhenEdit() throws IOException, SQLException {
        Task a = new Task();
        a.setId(1);
        boolean thrown = false;
        try{
            manager.removeTask(a);
            manager.editTask(a);
        } catch (TaskNotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testIfExceptionThrownOnNotExistingTaskWhenAssignToTask() throws IOException, SQLException {
        Task a = new Task();
        a.setId(1);
        a.setAssignedId(6);
        boolean thrown = false;
        try{
            manager.removeTask(a);
            manager.assignToTask(a);
        } catch (TaskNotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testIfExceptionThrownOnNotExistingTaskWhenRemove() throws IOException, SQLException {
        Task a = new Task();
        a.setId(1);
        a.setAssignedId(6);
        boolean thrown = false;
        try{
            manager.removeTask(a);
            manager.removeTask(a);
        } catch (TaskNotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testIfIdIsCorrectlySetAfterAdd() throws IOException, SQLException {
        Task a = new Task();
        a.setName("TaskName");
        int id = manager.addTask(a);
        assertEquals(manager.searchTask(a).size(),1);
    }

    @Test
    public void testAddAndRemoveTask() throws IOException, SQLException, TaskNotFoundException {

        Task a = new Task();
        a.setName("TaskName");
        int id = manager.addTask(a);
        Task b = new Task();
        b.setId(id);
        assertFalse(manager.searchTask(b).isEmpty());

        manager.removeTask(manager.searchTask(b).get(0));
        assertTrue(manager.searchTask(b).isEmpty());

    }

    @Test
    public void testIsIdSet() throws IOException, SQLException, TaskNotFoundException {

        Task a = new Task();
        a.setName("TestName");
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertNotNull(id);

        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsNameCorrect() throws IOException, SQLException, TaskNotFoundException {

        Task a = new Task();
        a.setName("TestName");
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getName().equals("TestName"));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsDescriptionCorrect() throws IOException, SQLException, TaskNotFoundException {

        Task a = new Task();
        a.setName("TestName");
        a.setDescription("TestDescription");
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getDescription().equals("TestDescription"));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsOwnerIdCorrect() throws IOException, SQLException, TaskNotFoundException {

        Task a = new Task();
        a.setName("TestName");
        a.setOwnerId(30);
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getOwnerId().equals(30));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsAssignedIdCorrect() throws IOException, SQLException, TaskNotFoundException {
        Task a = new Task();
        a.setName("TestName");
        a.setAssignedId(30);
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getAssignedId().equals(30));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsStartDateCorrect() throws ParseException, IOException, SQLException, TaskNotFoundException {
        Task a = new Task();
        String oldstring = "2011-01-18";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);

        a.setName("TestName");
        a.setStartDate(date);
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getStartDate().equals(date));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsTimeEstimateCorrect() throws IOException, SQLException, TaskNotFoundException {
        Task a = new Task();
        a.setName("TestName");
        a.setTimeEstimate(30);
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getTimeEstimate().equals(30));
        manager.removeTask(manager.searchTask(b).get(0));
    }


    @Test
    public void testIsStatusCorrect() throws IOException, SQLException, TaskNotFoundException {
        Task a = new Task();
        a.setName("TaskName");
        a.setStatus(Task.Status.FINISHED);
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getStatus().equals(Task.Status.FINISHED));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testIsPriorityCorrect() throws IOException, SQLException, TaskNotFoundException {
        Task a = new Task();
        a.setName("TaskName");
        a.setPriority(2);
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());

        assertTrue(manager.searchTask(b).get(0).getPriority().equals(2));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testEditTask() throws ParseException, IOException, SQLException, TaskNotFoundException {
        System.out.println("\n\n\n testEditTask \n\n\n");

        String oldstring = "2011-01-18";
        String oldstring1 = "2017-11-20";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring1);

        Task a = new Task();
        a.setName("testEditTask1");
        a.setDescription("testEditTask1");
        a.setStartDate(date);
        a.setTimeEstimate(20);
        a.setPriority(1);
        a.setAssignedId(4);
        a.setOwnerId(3);
        a.setStatus(Task.Status.ASSIGNED);

        int id = manager.addTask(a);
        Task b = new Task();

        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());
        a.setId(id);
        a.setName("testEditTask");
        a.setDescription("testEditTask");
        a.setStartDate(date1);
        a.setTimeEstimate(30);
        a.setPriority(2);
        a.setAssignedId(2);
        a.setOwnerId(1);
        a.setStatus(Task.Status.FINISHED);

        for(Task Task: manager.searchTask(b)){
            System.out.println("\n"+Task+"\n");
        }

        manager.editTask(a);

        for(Task Task: manager.searchTask(b)){
            System.out.println("\n"+Task+"\n");
        }

        assertTrue(manager.searchTask(b).get(0).getName().equals(a.getName()));
        assertTrue(manager.searchTask(b).get(0).getId().equals(a.getId()));
        assertTrue(manager.searchTask(b).get(0).getDescription().equals(a.getDescription()));
        assertTrue(manager.searchTask(b).get(0).getStartDate().equals(a.getStartDate()));
        assertTrue(manager.searchTask(b).get(0).getTimeEstimate().equals(a.getTimeEstimate()));
        assertTrue(manager.searchTask(b).get(0).getAssignedId().equals(a.getAssignedId()));
        assertTrue(manager.searchTask(b).get(0).getOwnerId().equals(a.getOwnerId()));
        assertTrue(manager.searchTask(b).get(0).getStatus().equals(a.getStatus()));
        assertTrue(manager.searchTask(b).get(0).getPriority().equals(a.getPriority()));

        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testAssignedToTask() throws IOException, SQLException, TaskNotFoundException {
        System.out.println("\n\n\n testAssignedToTask \n\n\n");

        Task a = new Task();
        a.setName("testAssignedToTask");
        int id = manager.addTask(a);

        Task b = new Task();
        b.setId(id);

        assertFalse(manager.searchTask(b).isEmpty());
        a.setId(id);
        a.setAssignedId(3);

        for(Task Task: manager.searchTask(b)){
            System.out.println("\n"+Task+"\n");
        }

        manager.assignToTask(a);

        for(Task Task: manager.searchTask(b)){
            System.out.println("\n"+Task+"\n");
        }

        assertTrue(manager.searchTask(b).get(0).getAssignedId().equals(3));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testSearchByLook() throws IOException, SQLException, TaskNotFoundException {
        System.out.println("\n\n\n testSearchByLook \n\n\n");
        Task a = new Task();
        Task b = new Task();

        a.setName("testSearchByLook");
        a.setDescription("testSearchByLook");
        b.setName("testSearchByLook");
        b.setDescription("testSearchByLook2");
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        Task searchTask = new Task();
        searchTask.setId(id);
        searchTask.setName("testSearchByLook");
        searchTask.setDescription("testSearchByLook");

        List<Task> list=manager.searchTask(searchTask);
        for (Task look : list){
            System.out.println("\n"+look+"\n");

            if (searchTask.getId()!=null){
                assertEquals(look.getId(),searchTask.getId());
            } else {
                if (searchTask.getName() != null) {
                    assertEquals(look.getName(),searchTask.getName());
                }
                if (searchTask.getDescription() != null) {
                    assertEquals(look.getDescription(),searchTask.getDescription());
                }
                if (searchTask.getAssignedId() != null) {
                    assertEquals(look.getAssignedId(),searchTask.getAssignedId());
                }
                if (searchTask.getOwnerId() != null) {
                    assertEquals(look.getOwnerId(),searchTask.getOwnerId());
                }
                if (searchTask.getPriority() != null) {
                    assertEquals(look.getPriority(),searchTask.getPriority());
                }
                if (searchTask.getStartDate() != null) {
                    assertEquals(look.getStartDate(),searchTask.getStartDate());
                }
                if (searchTask.getStatus() != null) {
                    assertEquals(look.getStatus(),searchTask.getStatus());
                }
                if (searchTask.getTimeEstimate() != null) {
                    assertEquals(look.getTimeEstimate(),searchTask.getTimeEstimate());
                }
            }
        }

        manager.removeTask(manager.searchTask(a).get(0));
        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testSearchByAssigned() throws IOException, SQLException, TaskNotFoundException {
        System.out.println("\n\n\n testSearchByAssigned \n\n\n");

        Task a = new Task();
        Task b = new Task();

        a.setName("testSearchByAssigned");
        a.setAssignedId(1);
        b.setName("testSearchByAssigned");
        b.setAssignedId(2);
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        Task searchTask = new Task();
        searchTask.setAssignedId(1);

        List<Task> list=manager.searchTaskByAssignedEmployee(searchTask.getAssignedId());
        for (Task look : list){
            System.out.println("\n"+look+"\n");
            assertEquals(look.getAssignedId(),searchTask.getAssignedId());
        }

        manager.removeTask(manager.searchTask(a).get(0));
        manager.removeTask(manager.searchTask(b).get(0));
    }
    @Test
    public void testSearchByOwner() throws IOException, SQLException, TaskNotFoundException {
        System.out.println("\n\n\n testSearchByOwner \n\n\n");

        Task a = new Task();
        Task b = new Task();

        a.setName("testSearchByAssigned");
        a.setOwnerId(1);
        b.setName("testSearchByAssigned");
        b.setOwnerId(2);
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        Task searchTask = new Task();
        searchTask.setOwnerId(1);

        List<Task> list=manager.searchTaskByOwnerEmployee(searchTask.getOwnerId());
        for (Task look : list){
            System.out.println("\n"+look+"\n");
            assertEquals(look.getOwnerId(),searchTask.getOwnerId());
        }

        manager.removeTask(manager.searchTask(a).get(0));
        manager.removeTask(manager.searchTask(b).get(0));
    }
    @Test
    public void testGetAll() throws IOException, SQLException, TaskNotFoundException {
       // QueryManager manager = new QueryManager("build/tmp/addTaskTest3k");
        Task a = new Task();
        a.setName("TaskName");
        int id = manager.addTask(a);
        Task b = new Task();
        b.setId(id);

        assertFalse(manager.getAll().isEmpty());

        manager.removeTask(manager.searchTask(b).get(0));
    }

    @Test
    public void testSearchByPhrase() throws IOException, SQLException, TaskNotFoundException {
        Task a = new Task();
        Task b = new Task();

        a.setName("testSearchByPhrase");
        a.setDescription("testSearchByPhrase");
        a.setOwnerId(1);
        b.setName("test2SearchByPhrase");
        b.setDescription("test2SearchByPhrase");
        b.setOwnerId(11);
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        assertFalse(manager.search("test").isEmpty());

        String searchPhrase = "testSearchByPhrase";
        String tmpWord;
        int value;
        int check=0;

        List<Task> list=manager.search(searchPhrase);
        for (Task look : list){
            System.out.println("\n"+look+"\n");
            tmpWord = look.getId().toString();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getName();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getDescription();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getOwnerId().toString();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getAssignedId().toString();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getTimeEstimate().toString();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getStartDate().toString();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            tmpWord = look.getStatus().toString();
            value = tmpWord.indexOf(searchPhrase);
            if(value >= 0){
                check++;
                continue;
            }
            assertTrue(check>0);
            check=0;
        }

        manager.removeTask(manager.searchTask(a).get(0));
        manager.removeTask(manager.searchTask(b).get(0));
    }
}
