package io2017.pierogimroku.task;

import io2017.pierogimroku.task.api.TaskContainerException;
import io2017.pierogimroku.task.api.TaskLook;

import java.util.List;
import java.util.Scanner;

public class ApiTester {
    public static ORMLiteTaskManager tm=null;
    public static final Scanner stdin=new Scanner(System.in);

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
            System.out.println("Menu:\n1 - Lista tasków\n2 - Dodaj task\n3 - Usuń task\n4 - Edytuj task\n5 -Przypisz do task'a\n6 - Wyszukaj task\n0 - Koniec\n");
            choice=stdin.nextInt();
            switch (choice) {
                case 1:
                    List<TaskLook> list=tm.getAll();
                    for (TaskLook tl : list){
                        System.out.println("Id: "+tl.getId()+",\tName: "+tl.getName()+",\tAssigned: "+tl.getAssignedId()+",\tDescription: "+tl.getDescription());
                    }
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }
}
