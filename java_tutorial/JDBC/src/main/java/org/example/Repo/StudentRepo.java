package org.example.Repo;

import org.example.Domain.model.Student;

import java.util.List;

public interface StudentRepo {

    int  createStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
}
