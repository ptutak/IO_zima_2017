package io2017.pierogimroku.task;

import com.j256.ormlite.logger.LocalLog;
import io2017.pierogimroku.task.api.TaskContainerException;
import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.api.TaskNotFoundException;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ApiTester {
    public static ORMLiteTaskManager tm=null;
    public static final Scanner stdin=new Scanner(System.in);

    public static void taskList(){
        List<TaskLook> list=tm.getAll();
        for (TaskLook look : list){
            System.out.println(look);
        }
    }

    public static void addTask(){
        TaskLook newTask=new TaskLook();
        System.out.println("Task Name:");
        newTask.setName(stdin.nextLine());
        System.out.println("Task Owner Id:");
        newTask.setOwnerId(Integer.parseInt(stdin.nextLine()));
        System.out.println("Task Assigned Id:");
        newTask.setAssignedId(Integer.parseInt(stdin.nextLine()));
        System.out.println("Task Description:");
        newTask.setDescription(stdin.nextLine());
        System.out.println("Task Priority:");
        newTask.setPriority(Integer.parseInt(stdin.nextLine()));
        System.out.println("Task Status:");
        System.out.println("1-NEW\n2-FINISHED\n3-ASSIGNED\n4-IN_REVIEW\n5-UNDER_IMPLEMENTATION\n");
        int choice=Integer.parseInt(stdin.nextLine());
        switch(choice){
            case 1:
                newTask.setStatus(TaskLook.Status.NEW);
                break;
            case 2:
                newTask.setStatus(TaskLook.Status.FINISHED);
                break;
            case 3:
                newTask.setStatus(TaskLook.Status.ASSIGNED);
                break;
            case 4:
                newTask.setStatus(TaskLook.Status.IN_REVIEW);
                break;
            case 5:
                newTask.setStatus(TaskLook.Status.UNDER_IMPLEMENTATION);
                break;
        }
        tm.addTask(newTask);
    }

    public static void removeTask(){
        System.out.println("Task Id:");
        TaskLook toRemove=new TaskLook(Integer.parseInt(stdin.nextLine()));
        try {
            tm.removeTask(toRemove);
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void editTask(){
        taskList();
        System.out.println("Choose task by Id:");
        System.out.println("Task Id:");
        TaskLook editTask=new TaskLook(Integer.parseInt(stdin.nextLine()));
        System.out.println("Edit task properties:");
        System.out.println("Task Name:");
        editTask.setName(stdin.nextLine());
        System.out.println("Task Owner Id:");
        editTask.setOwnerId(Integer.parseInt(stdin.nextLine()));
        System.out.println("Task Assigned Id:");
        editTask.setAssignedId(Integer.parseInt(stdin.nextLine()));
        System.out.println("Task Description:");
        editTask.setDescription(stdin.nextLine());
        System.out.println("Task Priority:");
        editTask.setPriority(Integer.parseInt(stdin.nextLine()));
        System.out.println("Task Status:");
        System.out.println("1-NEW\n2-FINISHED\n3-ASSIGNED\n4-IN_REVIEW\n5-UNDER_IMPLEMENTATION\n");
        int choice=Integer.parseInt(stdin.nextLine());
        switch(choice){
            case 1:
                editTask.setStatus(TaskLook.Status.NEW);
                break;
            case 2:
                editTask.setStatus(TaskLook.Status.FINISHED);
                break;
            case 3:
                editTask.setStatus(TaskLook.Status.ASSIGNED);
                break;
            case 4:
                editTask.setStatus(TaskLook.Status.IN_REVIEW);
                break;
            case 5:
                editTask.setStatus(TaskLook.Status.UNDER_IMPLEMENTATION);
                break;
        }
        try {
            tm.editTask(editTask);
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void searchTask(){
        System.out.println("Search task by:");
        System.out.println("1 - Id");
        System.out.println("2 - Name");
        System.out.println("3 - Owner Id");
        System.out.println("4 - Assigned Id");
        System.out.println("5 - Owner Id and Assigned Id");
        System.out.println("6 - Search phrase");
        int choice = Integer.parseInt(stdin.nextLine());
        Integer id=null;
        String phrase=null;
        TaskLook searchTask=new TaskLook();
        System.out.println("?Query:");
        switch (choice){
            case 1:
                searchTask.setId(Integer.parseInt(stdin.nextLine()));
                break;
            case 2:
                searchTask.setName(stdin.nextLine());
                break;
            case 3:
                id=Integer.parseInt(stdin.nextLine());
                break;
            case 4 :
                id=Integer.parseInt(stdin.nextLine());
                break;
            case 5:
                System.out.println("Owner Id:");
                searchTask.setOwnerId(Integer.parseInt(stdin.nextLine()));
                System.out.println("Assigned Id:");
                searchTask.setAssignedId(Integer.parseInt(stdin.nextLine()));
                break;
            case 6:
                phrase=stdin.nextLine();
                break;
        }
        List<TaskLook> list=null;
        if (id!=null){
            if (choice==3)
                list=tm.searchTaskByOwnerEmployee(id);
            else
                list=tm.searchTaskByAssignedEmployee(id);
        }
        else if (phrase!=null) {
            list=tm.search(phrase);
        }
        else
            list=tm.searchTaskByLook(searchTask);
        for (TaskLook look : list){
            System.out.println(look);
        }
    }
    
    public static void assignToTask(){
        taskList();
        System.out.println("Choose task by Id:");
        System.out.println("Task Id:");
        TaskLook editTask=new TaskLook(Integer.parseInt(stdin.nextLine()));
        System.out.println("Edit task properties:");
        System.out.println("Task Assigned Id:");
        editTask.setAssignedId(Integer.parseInt(stdin.nextLine()));
        try {
            tm.assignToTask(editTask);
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] argv){
        System.setProperty(LocalLog.LOCAL_LOG_LEVEL_PROPERTY, "ERROR");
        int choice=1;
        System.out.println("Wybierz bazę danych:");
        String db=stdin.nextLine();
        try {
            tm = new ORMLiteTaskManager("build/tmp/"+db);
        } catch (TaskContainerException e) {
            e.printStackTrace();
        }
        while (choice!=0){
            System.out.println("Menu:\n1 - Lista tasków\n2 - Dodaj task\n3 - Usuń task\n4 - Edytuj task\n5 - Wyszukaj task\n6 - Zmien przypisanego użytkownia\n0 - Koniec\n");
            choice=Integer.parseInt(stdin.nextLine());
            switch (choice) {
                case 1:
                    taskList();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    editTask();
                    break;
                case 5:
                    searchTask();
                    break;
                case 6:
                    assignToTask();
                    break;
            }
        }
    }
}
