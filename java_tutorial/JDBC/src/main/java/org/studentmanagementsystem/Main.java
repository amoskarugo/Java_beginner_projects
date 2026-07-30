package org.studentmanagementsystem;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.createSchemas.SqlSchema;
import org.studentmanagementsystem.service.servicesImpl.CourseServiceImpl;
import org.studentmanagementsystem.service.servicesImpl.StudentServiceImpl;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    SqlSchema.runCreateSchema();




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



        //CREATING MULTIPLE STUDENTS IN THE DATABASE
        List<Student> students = List.of(
                new Student("Daniel Kiptoo", "daniel.kiptoo@gmail.com"),
                new Student("Mercy Atieno", "mercy.atieno@gmail.com"),
                new Student("Peter Kamau", "peter.kamau@gmail.com"),
                new Student("Lucy Chebet", "lucy.chebet@gmail.com"),
                new Student("Samuel Mutiso", "samuel.mutiso@gmail.com")
        );

        StudentServiceImpl studentService = new StudentServiceImpl();
//       // students.forEach(studentService::saveStudent);
//        if (studentService.deleteStudentById(3))
//            System.out.println("Student with id " + 3 + " was deleted!");


        // UPDATING STUDENT

        Student updatedStudent = new Student("Ian Ambani", "ambaniIan@gmail.com");
        if (studentService.saveStudent(updatedStudent)){
            System.out.println("student created");
        }else{
            System.out.println("failed to create student");
        }

//        int id = 9;
//        if (studentService.updateStudentById(updatedStudent, id)){
//            System.out.println("Student with id " + id + " was updated!");
//        }else {
//            System.out.println("Student with id " + id + " was not updated!");
//        }


        CourseServiceImpl courseService = new CourseServiceImpl();
//        List<Course> courses = courseService.getAllCourses();
        Course course = new Course("Bachelors Information Technology");
//        courses.forEach(System.out::println);

// adding a course
//        if (courseService.addCourse(course)){
//            System.out.println("Course added successfully");
//        }else {
//            System.out.println("Course adding failed");
//        }


        //DELETE COURSE BY ID

//        if (courseService.deleteCourse(8)){
//            System.out.println("Course deleted successfully");
//        }else {
//            System.out.println("Course deleting failed");
//        }

//        if (courseService.updateCourse(course, 9)){
//            System.out.println("Course updated successfully");
//        }else {
//            System.out.println("Course update failed");
//        }

    }
}