package org.studentmanagementsystem.Repo;

import org.studentmanagementsystem.Domain.model.Student;

import java.util.List;

public interface StudentRepoInterface {

    int  createStudent(Student student);
    int updateStudentById(Student student, int id);
    int deleteStudent(int id);
    Student getStudentById(int id);
    List<Student> getAllStudents();
}
