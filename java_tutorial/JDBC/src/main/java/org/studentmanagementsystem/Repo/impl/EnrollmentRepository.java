package org.studentmanagementsystem.Repo.impl;

import org.studentmanagementsystem.Domain.SqlStatements.SqlQueries;
import org.studentmanagementsystem.Repo.EnrollmentRepoInterface;
import org.studentmanagementsystem.config.DatabaseConfig;
import org.studentmanagementsystem.dto.EnrollmentDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentRepository implements EnrollmentRepoInterface {


    private static final Connection con;
    private static PreparedStatement ps;

    private static StudentRepository studentRepo;

    static {
        con = DatabaseConfig.getDbConnection();
    }
    @Override
    public int enrollStudent(int student_id, int course_id) {
        int rowsAffected = 0;

        try {
            ps = con.prepareStatement(SqlQueries.EnrollmentQuery.enrollStudent);
            ps.setInt(1, student_id);
            ps.setInt(2, course_id);

            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;

        }catch (SQLException e) {
            return rowsAffected;
        }
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
