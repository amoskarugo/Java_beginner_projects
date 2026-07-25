package org.example.Repo;

import org.example.Domain.model.Student;

import java.util.List;

public interface StudentRepoInterface {

    int  createStudent(Student student);
    int updateStudentById(int id);
    int deleteStudent(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
}
