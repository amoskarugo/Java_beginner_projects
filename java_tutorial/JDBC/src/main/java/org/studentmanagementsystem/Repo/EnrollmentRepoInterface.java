package org.studentmanagementsystem.Repo;

import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.dto.EnrollmentDetails;

public interface EnrollmentRepoInterface {

    int enrollStudent(Student student, int course_id);
    Long updateStudentEnrollment(Long student_id, String status);
    EnrollmentDetails getStudentEnrollmentDetails(Long student_id);

}
