package org.studentmanagementsystem.Repo;

import org.studentmanagementsystem.dto.EnrollmentDetails;

public interface EnrollmentRepoInterface {

    int enrollStudent(int student_id, int course_id);
    Long updateStudentEnrollment(Long student_id, String status);
    EnrollmentDetails getStudentEnrollmentDetails(Long student_id);

}
