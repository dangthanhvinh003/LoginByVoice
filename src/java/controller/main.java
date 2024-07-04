/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("python", "C:\\Users\\Administrator\\test.py");
        Process p = pb.start();

        // Read the script's output
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = in.readLine()) != null) {
            output.append(line).append("\n");
        }
        System.out.println(output.toString());
//        line = output.toString();
//        line.trim().toLowerCase();
//
//        line = Character.toLowerCase(line.charAt(0)) + line.substring(1);
//
//        System.out.println(line);
//        // Send the output to the client
//        String[] parts = output.toString().split("\\s+"); // Tách các phần bằng khoảng trắng
//
//        StringBuilder usernameText = new StringBuilder();
//        StringBuilder passwordText = new StringBuilder();
//
//        boolean isUsername = false;
//        boolean isPassword = false;
//
//        for (int i = 0; i < parts.length; i++) {
//            if (isUsername) {
//                if (!parts[i].equals("password")) {
//                    usernameText.append(parts[i]);
//                } else {
//                    isUsername = false;
//                    isPassword = true;
//                }
//            } else if (isPassword) {
//                passwordText.append(parts[i]);
//            }
//
//            if (parts[i].equals("username")) {
//                isUsername = true;
//            } else if (parts[i].equals("password")) {
//                isPassword = true;
//            }
//        }
//
//        // Loại bỏ khoảng trắng và ghép lại username và password
//        String username = usernameText.toString().replaceAll("\\s", "");
//        String password = passwordText.toString().replaceAll("\\s", "");
//        System.out.println(username);
//        System.out.println(password);
    }
}
