package org.example.service.servicesImpl;

import org.example.Repo.StudentRepoInterface;
import org.example.Repo.impl.StudentRepository;

public class StudentServiceImpl {

    StudentRepository studentRepo = new StudentRepository();
    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentServiceImpl() {
    }



}


