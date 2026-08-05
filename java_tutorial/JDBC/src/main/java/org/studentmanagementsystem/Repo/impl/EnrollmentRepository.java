package org.studentmanagementsystem.Repo.impl;

import org.studentmanagementsystem.Domain.SqlStatements.SqlQueries;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Repo.EnrollmentRepoInterface;
import org.studentmanagementsystem.config.DatabaseConfig;
import org.studentmanagementsystem.dto.EnrollmentDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentRepository implements EnrollmentRepoInterface {


    private static final Connection con;
    private static PreparedStatement ps;

    private static final StudentRepository studentRepo;

    static {
        con = DatabaseConfig.getDbConnection();
        studentRepo = new StudentRepository();
    }
    @Override
    public int enrollStudent(Student student, int course_id) {
        int new_student_id = studentRepo.createStudent(student);
        int rowsAffected = 0;

        try {
            ps = con.prepareStatement(SqlQueries.EnrollmentQuery.enrollStudent);
            ps.setInt(1, new_student_id);
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
