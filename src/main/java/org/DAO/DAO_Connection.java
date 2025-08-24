package org.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO_Connection {

    private static final String URL = "jdbc:postgresql://localhost:5432/ToDo-Java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        //Tries connecting to the DB
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
