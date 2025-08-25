package org.view;

import org.DAO.DAO_Operations;
import org.model.Task;

import java.util.List;

public class ReadMenu {

    public static void printTasks(){
        List<Task> taskList = DAO_Operations.readAllTasks();

        for(Task task : taskList){
            System.out.println();
            System.out.println(task.toString());
        }
    }

    public static void start() {
        printTasks();
    }
}
