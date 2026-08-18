package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    Scanner scanner;
    public static final StudentServiceImpl studentService;
    public static final CourseServiceImpl  courseService;
    public static final EnrollmentServiceImpl enrollmentService;
    public AdminMenu(Scanner scanner) {
        this.scanner  = scanner;
    }
    static {
        studentService = new StudentServiceImpl();
        courseService = new CourseServiceImpl();
        enrollmentService = new EnrollmentServiceImpl();
    }

    public void ShowMenu() {
        boolean running = true;
        while (running){
            System.out.println("                                      Admin Dashboard                              ");
            System.out.println("                                      ===============                              ");
            System.out.println("                        1. Register New Student 2. Enroll A student into a course");
            System.out.println("                        3. Enter grades for a Student 4. View student details");
            System.out.println("                        0. Exit");
            printBreakLine();

            System.out.print("Select an option: ");
            String input = scanner.nextLine();

            try {
                switch (input) {
                    case "1" -> {
                        System.out.println("Registering a new student");
                        if (registerNewStudent())
                            System.out.println("New student registered successfully");
                        else
                            System.out.println("Failed to register new student");
                        printBreakLine();
                    }
                    case "2"->{
                        System.out.println("Enrolling a student into a course");
                        if (enrollToACourse())
                            System.out.println("Student enrolled successfully");
                        else
                            System.out.println("Failed to enroll student into a course");
                    }
                    case "3" ->
                            System.out.println("view student details");
                    case "4"->
                            System.out.println("exit");
                    case "0" ->
                            running = false;
                    default -> System.out.println("Invalid input, try again");
                }


            }catch (Exception e){
                System.out.println("an error occurred: " + e.getMessage());
            }
        }
    }
    public static void printBreakLine(){
        for (int i = 0; i < 120; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public  boolean registerNewStudent(){
        System.out.print("Enter student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        Student student = new Student(name,email);
        return studentService.saveStudent(student);
    }
    public boolean enrollToACourse(){
        List<Course> allCourses = new ArrayList<>();
        allCourses = courseService.getAllCourses();
        for (Course course : allCourses) {
            System.out.println("   -> Name: " + course.getCourseName() + "  " + " " + "Course id -> " + course.getCourseId());
        }
        System.out.println("Select a course to enroll student");
        System.out.print("Enter student id: ");
        int student_id = scanner.nextInt();
        Student student = studentService.retrieveStudentById(student_id);
        System.out.print("Enter course id: ");
        int course_id = scanner.nextInt();

        return enrollmentService.createEnrollment(student.getId(), course_id);
    }
    }

