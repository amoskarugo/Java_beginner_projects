package org.studentmanagementsystem.service;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.dto.EnrollmentDetails;

public interface EnrollmentService {

    boolean createEnrollment(int student_id, int course_id);
    boolean updateStudentStatus(Student student, String status);
    EnrollmentDetails getStudentEnrollmentDetails(int student_id);
}
