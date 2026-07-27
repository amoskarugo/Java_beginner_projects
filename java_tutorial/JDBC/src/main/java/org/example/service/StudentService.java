package org.example.service;

import org.example.Domain.model.Student;

import java.util.List;

public interface StudentService {

    boolean saveStudent(Student student);
    boolean deleteStudentById(int id);
    List<Student> listAllStudents();
    Student retrieveStudentById(int id);

    boolean updateStudentById(Student student,  int id);
}
