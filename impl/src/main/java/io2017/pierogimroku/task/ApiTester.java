package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.TaskContainerException;
import io2017.pierogimroku.task.api.TaskLook;
import io2017.pierogimroku.task.api.TaskNotFoundException;

import java.util.List;
import java.util.Scanner;

public class ApiTester {
    public static ORMLiteTaskManager tm=null;
    public static final Scanner stdin=new Scanner(System.in);

    public static void taskList(){
        List<TaskLook> list=tm.getAll();
        for (TaskLook look : list){
            System.out.println(look);
            //System.out.println("Id: "+tl.getId()+",\tName: "+tl.getName()+",\tOwner: "+tl.getOwnerId()+",\tAssigned: "+tl.getAssignedId()+",\nDescription: "+tl.getDescription());
        }
    }

    public static void addTask(){
        TaskLook newTask=new TaskLook();
        System.out.println("Task Name:");
        newTask.setName(stdin.nextLine());
        System.out.println("Task Owner Id:");
        newTask.setOwnerId(stdin.nextInt());
        System.out.println("Task Assigned Id:");
        newTask.setAssignedId(stdin.nextInt());
        System.out.println("Task Description:");
        newTask.setDescription(stdin.nextLine());
        tm.addTask(newTask);
    }

    public static void removeTask(){
        System.out.println("Task Id:");
        TaskLook toRemove=new TaskLook(stdin.nextInt());
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
        TaskLook editTask=new TaskLook(stdin.nextInt());
        System.out.println("Edit task properties:");
        System.out.println("Task Name:");
        editTask.setName(stdin.nextLine());
        System.out.println("Task Owner Id:");
        editTask.setOwnerId(stdin.nextInt());
        System.out.println("Task Assigned Id:");
        editTask.setAssignedId(stdin.nextInt());
        System.out.println("Task Description:");
        editTask.setDescription(stdin.nextLine());
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
        int choice = stdin.nextInt();
        TaskLook searchTask=new TaskLook();
        System.out.println("?Query:");
        switch (choice){
            case 1:
                searchTask.setId(stdin.nextInt());
                break;
            case 2:
                searchTask.setName(stdin.nextLine());
                break;
            case 3:
                searchTask.setOwnerId(stdin.nextInt());
                break;
            case 4 :
                searchTask.setAssignedId(stdin.nextInt());
                break;
        }
        List<TaskLook> list=tm.searchTaskByLook(searchTask);
        for (TaskLook look : list){
            System.out.println(look);
        }
    }
    public static void main(String[] argv){
        int choice=1;
        System.out.println("Wybierz bazę danych:");
        String db=stdin.nextLine();
        try {
            tm = new ORMLiteTaskManager(db);
        } catch (TaskContainerException e) {
            e.printStackTrace();
        }
        while (choice!=0){
            System.out.println("Menu:\n1 - Lista tasków\n2 - Dodaj task\n3 - Usuń task\n4 - Edytuj task\n5 - Wyszukaj task\n0 - Koniec\n");
            choice=stdin.nextInt();
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
            }
        }
    }
}
