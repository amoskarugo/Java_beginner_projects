package org.studentmanagementsystem.Repo;

import org.studentmanagementsystem.dto.EnrollmentDetails;

public interface EnrollmentRepoInterface {

    Long enrollStudent(Long student_id, Long course_id);
    Long updateStudentEnrollment(Long student_id, String status);
    EnrollmentDetails getStudentEnrollmentDetails(Long student_id);

}
