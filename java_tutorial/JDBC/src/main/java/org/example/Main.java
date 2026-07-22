package org.example;

import org.example.config.DatabaseConfig;
import org.example.service.StudentService;
import org.example.service.servicesImpl.StudentServiceImpl;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl();
        Connection dbConnection = DatabaseConfig.getDbConnection();
    }
}