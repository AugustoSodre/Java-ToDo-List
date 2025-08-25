package org.DAO;

import org.model.Task;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO_Operations {

    public static void createTask(Task task){
        //Query to be run

        //task = new Task("Test", "Just a test", Date.from(Instant.now()), 2, "TaskyTasky", "TODO");

        String query =
                "INSERT INTO task(taskname, description, deadline, " +
                "priority, category, status) " +
                "VALUES (?,?,?,?,?,?)";

        //Execution
        try {
            //Tries connecting to the DB
            Connection conn = DAO_Connection.getConnection();

            //Creates a prepared statement (to avoid SQL injection) and inserts
            //the info based on the Task Object
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(task.getDeadline().getTime()));
            preparedStatement.setInt(4, task.getPriority());
            preparedStatement.setString(5, task.getCategory());
            preparedStatement.setObject(6, task.getStatus(), java.sql.Types.OTHER);

            preparedStatement.executeUpdate();

            System.out.println("Task created successfully in the DB");

        } catch (SQLException e){
            System.out.println("An error happened:");
            System.out.println(e.getMessage());
        }

    }

    public static List<Task> readAllTasks(){
        //Query to be run
        String query = "SELECT * FROM Task";

        //List of tasks
        List<Task> tasks = new ArrayList<>();

        //Execution
        try {
            //Tries connecting to the DB
            Connection conn = DAO_Connection.getConnection();

            //Creates a statement to select and retrieve all Tasks in the DB
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //Based on the given ResultSet, trying to convert each element to a Task
            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("taskid"),
                        rs.getString("taskName"),
                        rs.getString("description"),
                        rs.getDate("deadline"),
                        rs.getInt("priority"),
                        rs.getString("category"),
                        rs.getString("status")
                );
                tasks.add(task);
            }

        } catch (SQLException e){
            System.out.println("An error happened:");
            System.out.println(e.getMessage());
        }


        return tasks;
    }

    public static void updateTask(int taskID){
        //TODO update task in DAO
    }

    public static void deleteTask(int taskID){
        //Query to be run
        String query = "DELETE FROM task WHERE taskid = ?";

        //Execution
        try {
            //Tries connecting to the DB
            Connection conn = DAO_Connection.getConnection();

            //Creates a prepared statement (to avoid SQL injection) and inserts
            //the taskID in it
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, taskID);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            System.out.println("An error happened:");
            System.out.println(e.getMessage());
        }



    }



}
