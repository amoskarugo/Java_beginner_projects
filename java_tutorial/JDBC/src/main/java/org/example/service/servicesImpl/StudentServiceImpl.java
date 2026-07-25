package org.example.service.servicesImpl;

import org.example.Domain.model.Student;
import org.example.Repo.impl.StudentRepository;
import org.example.exceptions.StudentNullPointerException;
import org.example.service.StudentService;

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
        return false;
    }

    @Override
    public List<Student> listAllStudents() {
        return List.of();
    }

    @Override
    public Student retrieveStudentById(int id) {
        return null;
    }

    @Override
    public boolean updateStudentById(int id) {
        return false;
    }
}


