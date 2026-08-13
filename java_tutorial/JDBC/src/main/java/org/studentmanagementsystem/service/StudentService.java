package org.studentmanagementsystem.service;

import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.dto.CurrentProgress;

import java.util.List;

public interface StudentService {

    boolean saveStudent(Student student);
    boolean deleteStudentById(int id);
    List<Student> listAllStudents();
    Student retrieveStudentById(int id);

    boolean updateStudentById(Student student,  int id);
    CurrentProgress getStudentCurrentProgress(int student_id);
}
