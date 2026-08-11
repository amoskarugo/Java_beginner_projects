package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Repo.impl.StudentRepository;
import org.studentmanagementsystem.exceptions.StudentNotFound;
import org.studentmanagementsystem.exceptions.StudentNullPointerException;
import org.studentmanagementsystem.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepo = new StudentRepository();
    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentServiceImpl() {
    }


    @Override
    public boolean saveStudent(Student student) {
        if (student == null) {
            throw new StudentNullPointerException("student cannot be null!");
        }

        return studentRepo.createStudent(student) > 0;

    }

    @Override
    public boolean deleteStudentById(int id) {
        if (studentRepo.deleteStudent(id) > 0) {
            return true;
        }else throw new StudentNotFound("student with id " + id + " does not exist!");
    }

    @Override
    public List<Student> listAllStudents() {
        return List.of();
    }

    @Override
    public Student retrieveStudentById(int id) {
        Student student = studentRepo.getStudentById(id);
        if (student == null)
            throw new StudentNotFound("student with id " + id + " is not found!!");
        return student;
    }

    @Override
    public boolean updateStudentById(Student student, int id) {
        return studentRepo.updateStudentById(student, id) > 0;
    }
}


