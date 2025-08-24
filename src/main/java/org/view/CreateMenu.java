package org.view;

import org.DAO.DAO_Operations;
import org.controller.CreateController;
import org.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateMenu {

    public static Task createTask() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Task task = null;

        try {
            System.out.println("Enter Task Name:");
            String name = reader.readLine();

            System.out.println("Enter Description:");
            String description = reader.readLine();

            System.out.println("Enter Deadline (yyyy-MM-dd):");
            String deadlineStr = reader.readLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date deadline = sdf.parse(deadlineStr);

            System.out.println("Enter Priority (1 to 5):");
            int priority = Integer.parseInt(reader.readLine());

            System.out.println("Enter Category:");
            String category = reader.readLine();

            System.out.println("Enter Status (TODO, DOING, DONE):");
            String status = reader.readLine().toUpperCase();
            while (!status.equals("TODO") && !status.equals("DOING") && !status.equals("DONE")) {
                System.out.println("Invalid status. Enter TODO, DOING, or DONE:");
                status = reader.readLine().toUpperCase();
            }

            // Create Task object
            task = new Task(name, description, deadline, priority, category, status);

            System.out.println("Task created successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        }

        return task;
    }

    public static void start() {
        //CreateController createController = new CreateController();

        Task task = createTask();

        while(task == null){
            task = createTask();
        }

        DAO_Operations.createTask(task);
    }


}
