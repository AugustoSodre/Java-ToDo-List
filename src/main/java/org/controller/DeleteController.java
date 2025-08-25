package org.controller;

import org.DAO.DAO_Operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteController {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void start() {
        delete();
    }

    public static void delete(){
        int id = getUserInput();

        DAO_Operations.deleteTask(id);
    }

    public static int getUserInput(){
        try {
            System.out.print("Please enter the Task ID: ");
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
