/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class VoiceCheck {
    private static String username;
    private static String password;
    public static void getSpeecḥ() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("python", "test.py");
        System.out.println(pb);
        Process p = pb.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ret = in.readLine();
        System.out.println("Python script output: " + ret);
//        String ret2 = in.readLine();
//        System.out.println("Python script output: " + ret2);

        //String text = "username v i n h u i o i o password v i n h p 1 2 3";
        String[] parts = ret.split("\\s+"); // Tách các phần bằng khoảng trắng

        StringBuilder usernameText = new StringBuilder();
        StringBuilder passwordText = new StringBuilder();

        boolean isUsername = false;
        boolean isPassword = false;

        for (int i = 0; i < parts.length; i++) {
            if (isUsername) {
                if (!parts[i].equals("password")) {
                    usernameText.append(parts[i]);
                } else {
                    isUsername = false;
                    isPassword = true;
                }
            } else if (isPassword) {
                passwordText.append(parts[i]);
            }

            if (parts[i].equals("username")) {
                isUsername = true;
            } else if (parts[i].equals("password")) {
                isPassword = true;
            }
        }

        // Loại bỏ khoảng trắng và ghép lại username và password
         username = usernameText.toString().replaceAll("\\s", "");
        password = passwordText.toString().replaceAll("\\s", "");

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
     public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
