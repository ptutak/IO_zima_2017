package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.TaskContainerException;
import io2017.pierogimroku.task.api.TaskLook;
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


public class ORMLiteTaskManagerTest {
    private ORMLiteTaskManager manager;
    private static final String TEST_DATABASE_NAME = "build/tmp/ORMLiteTaskManagerTest.db";

    @Before
    public void setup(){
        manager = new ORMLiteTaskManager(TEST_DATABASE_NAME);
    }

    @Test
    public void testIfExceptionThrownOnNotExistingTaskWhenEdit() throws IOException, SQLException {
        TaskLook a = new TaskLook();
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
        TaskLook a = new TaskLook();
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
        TaskLook a = new TaskLook();
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
    public void testIfIdIsCorrectlySetAfterAdd(){
        TaskLook a = new TaskLook();
        a.setName("TaskName");
        int id = manager.addTask(a);
        assertEquals(manager.searchTaskByLook(a).size(),1);
    }

    @Test
    public void testAddAndRemoveTask() throws TaskContainerException, TaskNotFoundException {

        TaskLook a = new TaskLook();
        a.setName("TaskName");
        int id = manager.addTask(a);
        TaskLook b = new TaskLook();
        b.setId(id);
        assertFalse(manager.searchTaskByLook(b).isEmpty());

        manager.removeTask(manager.searchTaskByLook(b).get(0));
        assertTrue(manager.searchTaskByLook(b).isEmpty());

    }

    @Test
    public void testIsIdSet() throws TaskNotFoundException {

        TaskLook a = new TaskLook();
        a.setName("TestName");
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertNotNull(id);

        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsNameCorrect() throws TaskNotFoundException {

        TaskLook a = new TaskLook();
        a.setName("TestName");
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getName().equals("TestName"));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsDescriptionCorrect() throws TaskNotFoundException {

        TaskLook a = new TaskLook();
        a.setName("TestName");
        a.setDescription("TestDescription");
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getDescription().equals("TestDescription"));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsOwnerIdCorrect() throws TaskNotFoundException {

        TaskLook a = new TaskLook();
        a.setName("TestName");
        a.setOwnerId(30);
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getOwnerId().equals(30));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsAssignedIdCorrect() throws TaskNotFoundException {
        TaskLook a = new TaskLook();
        a.setName("TestName");
        a.setAssignedId(30);
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getAssignedId().equals(30));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsStartDateCorrect() throws TaskNotFoundException, ParseException {
        TaskLook a = new TaskLook();
        String oldstring = "2011-01-18";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);

        a.setName("TestName");
        a.setStartDate(date);
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getStartDate().equals(date));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsTimeEstimateCorrect() throws TaskNotFoundException {
        TaskLook a = new TaskLook();
        a.setName("TestName");
        a.setTimeEstimate(30);
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getTimeEstimate().equals(30));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }


    @Test
    public void testIsStatusCorrect() throws TaskNotFoundException {
        TaskLook a = new TaskLook();
        a.setName("TaskName");
        a.setStatus(TaskLook.Status.FINISHED);
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getStatus().equals(TaskLook.Status.FINISHED));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testIsPriorityCorrect() throws TaskNotFoundException {
        TaskLook a = new TaskLook();
        a.setName("TaskName");
        a.setPriority(2);
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());

        assertTrue(manager.searchTaskByLook(b).get(0).getPriority().equals(2));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testEditTask() throws TaskContainerException, TaskNotFoundException, ParseException {
        System.out.println("\n\n\n testEditTask \n\n\n");

        String oldstring = "2011-01-18";
        String oldstring1 = "2017-11-20";
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(oldstring1);

        TaskLook a = new TaskLook();
        a.setName("testEditTask1");
        a.setDescription("testEditTask1");
        a.setStartDate(date);
        a.setTimeEstimate(20);
        a.setPriority(1);
        a.setAssignedId(4);
        a.setOwnerId(3);
        a.setStatus(TaskLook.Status.ASSIGNED);

        int id = manager.addTask(a);
        TaskLook b = new TaskLook();

        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());
        a.setId(id);
        a.setName("testEditTask");
        a.setDescription("testEditTask");
        a.setStartDate(date1);
        a.setTimeEstimate(30);
        a.setPriority(2);
        a.setAssignedId(2);
        a.setOwnerId(1);
        a.setStatus(TaskLook.Status.FINISHED);

        for(TaskLook taskLook: manager.searchTaskByLook(b)){
            System.out.println("\n"+taskLook+"\n");
        }

        manager.editTask(a);

        for(TaskLook taskLook: manager.searchTaskByLook(b)){
            System.out.println("\n"+taskLook+"\n");
        }

        assertTrue(manager.searchTaskByLook(b).get(0).getName().equals(a.getName()));
        assertTrue(manager.searchTaskByLook(b).get(0).getId().equals(a.getId()));
        assertTrue(manager.searchTaskByLook(b).get(0).getDescription().equals(a.getDescription()));
        assertTrue(manager.searchTaskByLook(b).get(0).getStartDate().equals(a.getStartDate()));
        assertTrue(manager.searchTaskByLook(b).get(0).getTimeEstimate().equals(a.getTimeEstimate()));
        assertTrue(manager.searchTaskByLook(b).get(0).getAssignedId().equals(a.getAssignedId()));
        assertTrue(manager.searchTaskByLook(b).get(0).getOwnerId().equals(a.getOwnerId()));
        assertTrue(manager.searchTaskByLook(b).get(0).getStatus().equals(a.getStatus()));
        assertTrue(manager.searchTaskByLook(b).get(0).getPriority().equals(a.getPriority()));

        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testAssignedToTask() throws TaskNotFoundException {
        System.out.println("\n\n\n testAssignedToTask \n\n\n");

        TaskLook a = new TaskLook();
        a.setName("testAssignedToTask");
        int id = manager.addTask(a);

        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.searchTaskByLook(b).isEmpty());
        a.setId(id);
        a.setAssignedId(3);

        for(TaskLook taskLook: manager.searchTaskByLook(b)){
            System.out.println("\n"+taskLook+"\n");
        }

        manager.assignToTask(a);

        for(TaskLook taskLook: manager.searchTaskByLook(b)){
            System.out.println("\n"+taskLook+"\n");
        }

        assertTrue(manager.searchTaskByLook(b).get(0).getAssignedId().equals(3));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testSearchByLook() throws TaskNotFoundException {
        System.out.println("\n\n\n testSearchByLook \n\n\n");
        TaskLook a = new TaskLook();
        TaskLook b = new TaskLook();

        a.setName("testSearchByLook");
        a.setDescription("testSearchByLook");
        b.setName("testSearchByLook");
        b.setDescription("testSearchByLook2");
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        TaskLook searchTask = new TaskLook();
        searchTask.setId(id);
        searchTask.setName("testSearchByLook");
        searchTask.setDescription("testSearchByLook");

        List<TaskLook> list=manager.searchTaskByLook(searchTask);
        for (TaskLook look : list){
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

        manager.removeTask(manager.searchTaskByLook(a).get(0));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testSearchByAssigned() throws TaskNotFoundException {
        System.out.println("\n\n\n testSearchByAssigned \n\n\n");

        TaskLook a = new TaskLook();
        TaskLook b = new TaskLook();

        a.setName("testSearchByAssigned");
        a.setAssignedId(1);
        b.setName("testSearchByAssigned");
        b.setAssignedId(2);
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        TaskLook searchTask = new TaskLook();
        searchTask.setAssignedId(1);

        List<TaskLook> list=manager.searchTaskByAssignedEmployee(searchTask.getAssignedId());
        for (TaskLook look : list){
            System.out.println("\n"+look+"\n");
            assertEquals(look.getAssignedId(),searchTask.getAssignedId());
        }

        manager.removeTask(manager.searchTaskByLook(a).get(0));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }
    @Test
    public void testSearchByOwner() throws TaskNotFoundException {
        System.out.println("\n\n\n testSearchByOwner \n\n\n");

        TaskLook a = new TaskLook();
        TaskLook b = new TaskLook();

        a.setName("testSearchByAssigned");
        a.setOwnerId(1);
        b.setName("testSearchByAssigned");
        b.setOwnerId(2);
        int id = manager.addTask(a);
        a.setId(id);
        int id2 = manager.addTask(b);
        b.setId(id2);

        TaskLook searchTask = new TaskLook();
        searchTask.setOwnerId(1);

        List<TaskLook> list=manager.searchTaskByOwnerEmployee(searchTask.getOwnerId());
        for (TaskLook look : list){
            System.out.println("\n"+look+"\n");
            assertEquals(look.getOwnerId(),searchTask.getOwnerId());
        }

        manager.removeTask(manager.searchTaskByLook(a).get(0));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }
    @Test
    public void testGetAll() throws TaskContainerException, TaskNotFoundException {
       // ORMLiteTaskManager manager = new ORMLiteTaskManager("build/tmp/addTaskTest1k");

        TaskLook a = new TaskLook();
        a.setName("TaskName");
        int id = manager.addTask(a);
        TaskLook b = new TaskLook();
        b.setId(id);

        assertFalse(manager.getAll().isEmpty());

        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }

    @Test
    public void testSearchByPhrase() throws TaskNotFoundException, TaskContainerException {
        TaskLook a = new TaskLook();
        TaskLook b = new TaskLook();

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

        List<TaskLook> list=manager.search(searchPhrase);
        for (TaskLook look : list){
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

        manager.removeTask(manager.searchTaskByLook(a).get(0));
        manager.removeTask(manager.searchTaskByLook(b).get(0));
    }
}

