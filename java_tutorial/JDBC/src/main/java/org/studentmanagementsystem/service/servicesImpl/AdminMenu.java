package org.studentmanagementsystem.service.servicesImpl;

import java.util.Scanner;

public class AdminMenu {
    Scanner scanner;
    public AdminMenu(Scanner scanner) {
        this.scanner  = scanner;
    }

    public void ShowMenu() {
        boolean running = true;
        while (running){
            System.out.println("                                      Admin Dashboard                              ");
            System.out.println("                                      ===============                              ");
            System.out.println("                        1. Register New Student 2. Enroll A student into a course");
            System.out.println("                        3. Enter grades for a Student 4. View student details");
            System.out.println("                        0. Exit");
            System.out.println("                        3. Enter grades for a Student 4. View student details");
            printBreakLine();

            System.out.print("Select an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1"->
                        System.out.println("registering a new student");
                case "2"->
                        System.out.println("enrolling a student into a course");
                case "3" ->
                        System.out.println("view student details");
                case "4"->
                        System.out.println("exit");
                case "0" ->
                        running = false;
                default -> System.out.println("Invalid input, try again");
            }

        }
    }
    public static void printBreakLine(){
        for (int i = 0; i < 120; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    }

