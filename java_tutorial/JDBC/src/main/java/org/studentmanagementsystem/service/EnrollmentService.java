package org.studentmanagementsystem.service;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;

public interface EnrollmentService {

    boolean createEnrollment(Student student, int course_id);
    boolean updateStudentStatus(Student student, String status);
}
