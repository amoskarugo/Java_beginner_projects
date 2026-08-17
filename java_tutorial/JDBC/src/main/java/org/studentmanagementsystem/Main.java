package org.studentmanagementsystem;
import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.dto.EnrollmentDetails;
import org.studentmanagementsystem.service.servicesImpl.CourseServiceImpl;
import org.studentmanagementsystem.service.servicesImpl.EnrollmentServiceImpl;
import org.studentmanagementsystem.service.servicesImpl.GradeService;
import org.studentmanagementsystem.service.servicesImpl.StudentServiceImpl;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //SqlSchema.runCreateSchema();

        Scanner scanner = new Scanner(System.in);


        StudentServiceImpl studentService = new StudentServiceImpl();
        Student new_student = new Student("Eric macharia", "erico@gmail.com");
        EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl();
        Student updateStudentStatus = studentService.retrieveStudentById(25);
        EnrollmentDetails enrollmentDetails = enrollmentService.getStudentEnrollmentDetails(25);
        System.out.println(enrollmentDetails);


    }
}