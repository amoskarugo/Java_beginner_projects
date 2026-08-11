package org.studentmanagementsystem.Repo.impl;

import org.studentmanagementsystem.Domain.SqlStatements.SqlQueries;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Repo.EnrollmentRepoInterface;
import org.studentmanagementsystem.config.DatabaseConfig;
import org.studentmanagementsystem.dto.EnrollmentDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnrollmentRepository implements EnrollmentRepoInterface {


    private static final Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

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
    public int updateStudentEnrollment(int student_id, String status) {

        int rowsAffected = 0;
        try {
            ps = con.prepareStatement(SqlQueries.EnrollmentQuery.updateEnrollment);
            ps.setString(1, status);
            ps.setInt(2, student_id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;

        }catch (SQLException e){
            System.out.println("Couldn't update student status " + e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public EnrollmentDetails getStudentEnrollmentDetails(int student_id) {

        EnrollmentDetails enrollmentDetails = null;
        try {
            ps = con.prepareStatement(SqlQueries.EnrollmentQuery.studentEnrollmentDetails);
            ps.setInt(1, student_id);
            rs =  ps.executeQuery();
            while (rs.next()) {
                enrollmentDetails = new EnrollmentDetails(rs.getInt("enrollment_id"), rs.getString("name"),
                        rs.getInt("id"), rs.getString("course_name"), rs.getString("status"),
                        rs.getTimestamp("enrollment_date").toLocalDateTime());
            }
            ps.close();

        }catch (SQLException e) {
            System.out.println("Couldn't get student enrolment details " + e.getMessage());
        }
        return enrollmentDetails;
    }
}
