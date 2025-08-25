package org.view;

import org.DAO.DAO_Operations;
import org.controller.MainMenuController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainMenu {

    public static void start() {

        //Main loop of the whole Application
        while (true) {
            printMainMenu();

            chooseOptionMenu();
        }
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("-----------------------------");

        System.out.println("Main Menu");
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("1. Add Task");
        System.out.println("2. Show Tasks");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("0. Exit");

        System.out.println("-----------------------------");
        System.out.println();
    }

    public static void cleanScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void chooseOptionMenu(){
        //Controller instance
        MainMenuController controller = new MainMenuController();

        //Matching the chosen option
        switch (controller.getUserInput()) {
            case 0:
                System.exit(0);

            case 1:
                cleanScreen();
                CreateMenu.start();
                break;

            case 2:
                cleanScreen();
                ReadMenu.start();
                break;

            case 3:
                //TODO - update menu
                cleanScreen();
                //updateMenu.getClass();
                break;

            case 4:
                cleanScreen();
                DeleteMenu.start();
                break;

            default:
                System.out.println("Invalid input");
                cleanScreen();
                break;
        }
    }

}
