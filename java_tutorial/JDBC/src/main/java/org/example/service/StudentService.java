package org.example.service;

import org.example.Domain.model.Student;

import java.util.List;

public interface StudentService {

    void createStudent(String name, String email);
    boolean deleteStudentBtId(int id);
    List<Student> getAllStudents();
    Student getStudentById(int id);
}
