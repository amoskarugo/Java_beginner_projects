package org.studentmanagementsystem.Repo;

public interface EnrollmentRepoInterface {

    Long enrollStudent(Long student_id, Long course_id);
    Long updateStudentEnrollment(Long student_id, String status);

}
