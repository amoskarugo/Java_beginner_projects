package org.studentmanagementsystem;
import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.dto.EnrollmentDetails;
import org.studentmanagementsystem.service.servicesImpl.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //SqlSchema.runCreateSchema();

        Scanner scanner = new Scanner(System.in);
        AdminMenu adminMenu = new AdminMenu(scanner);
        adminMenu.ShowMenu();
    }
}