package org.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenuController {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int getUserInput(){
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
