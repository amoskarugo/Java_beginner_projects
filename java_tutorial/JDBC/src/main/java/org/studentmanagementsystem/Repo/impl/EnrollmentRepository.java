package org.studentmanagementsystem.Repo.impl;

import org.studentmanagementsystem.Repo.EnrollmentRepoInterface;
import org.studentmanagementsystem.config.DatabaseConfig;
import org.studentmanagementsystem.dto.EnrollmentDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnrollmentRepository implements EnrollmentRepoInterface {


    private static final Connection con;
    private static PreparedStatement ps;

    private static StudentRepository studentRepo;

    static {
        con = DatabaseConfig.getDbConnection();
    }
    @Override
    public Long enrollStudent(Long student_id, Long course_id) {
        return 0L;
    }

    @Override
    public Long updateStudentEnrollment(Long student_id, String status) {
        return 0L;
    }

    @Override
    public EnrollmentDetails getStudentEnrollmentDetails(Long student_id) {
        return null;
    }
}
