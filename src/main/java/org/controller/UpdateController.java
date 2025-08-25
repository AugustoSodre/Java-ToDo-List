package org.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateController {

    //TODO complete each option of updating in the menu

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void start() {

    }

    public static void update() {
        System.out.print("Please enter the id of the Task you would like to update: ");
        int id = getNumberInput();

        int input = -1;
        while (input != 0) {
            System.out.println("Please enter what type of information you would like to update: ");
            System.out.println("1. Name");
            System.out.println("2. Description");
            System.out.println("3. Deadline");
            System.out.println("4. Priority");
            System.out.println("5. Category");
            System.out.println("6. Status");
            System.out.println("0. Exit");

            input = getNumberInput();
        }




    }

    public static int getNumberInput(){
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStringInput(){
        try{
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public static Date getDateInput(){
//        try{
//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//
//        }
//    }
}
