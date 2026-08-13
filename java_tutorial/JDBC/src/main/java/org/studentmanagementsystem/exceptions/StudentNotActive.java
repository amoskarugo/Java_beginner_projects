package org.studentmanagementsystem.exceptions;

public class StudentNotActive extends RuntimeException {
    public StudentNotActive(String message) {
        super(message);
    }
}
