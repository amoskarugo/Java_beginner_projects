package org.example;

import org.example.Domain.model.Student;
import org.example.Repo.RunSqlQueries;
import org.example.createSchemas.SqlSchema;
import org.example.service.StudentService;
import org.example.service.servicesImpl.StudentServiceImpl;

import java.sql.Connection;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(SqlSchema.runCreateSchema());

        StudentService studentService = new StudentServiceImpl();
//        studentService.createStudent("amos", "karugoamos@gmail.com");

//        if (studentService.deleteStudentById(1)) {
//            System.out.println("student deleted");
//        }else  {
//            System.out.println("deleting student failed!");
//        }

//        Student student = studentService.getStudentById(12);
//        if (student != null) {
//            System.out.println("Name: " + student.getName() +
//                    " email: " + student.getEmail());
//        }else  {
//            System.out.println("student not found!");
//        }

//        List<Student> students = studentService.getAllStudents();
//        if (!students.isEmpty()) {
//            students.forEach(System.out::println);
//        }else  {
//            System.out.println("No students found");
//        }


    }
}