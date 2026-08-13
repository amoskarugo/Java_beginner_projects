package org.studentmanagementsystem.service;

import org.studentmanagementsystem.Domain.model.Student;

import java.math.BigDecimal;
import java.util.Scanner;

public interface GradeInterface {

    void enterGradeForStudent(Scanner scanner, int regNumber);
    boolean updateGradeForStudent(int regNumber);
}
