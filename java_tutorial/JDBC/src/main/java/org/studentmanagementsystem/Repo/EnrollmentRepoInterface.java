package org.studentmanagementsystem.Repo;

import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.dto.EnrollmentDetails;

public interface EnrollmentRepoInterface {

    boolean enrollStudent(Student student, int course_id);
    int updateStudentEnrollment(int student_id, String status);
    EnrollmentDetails getEnrollmentDetails(int student_id);

}
