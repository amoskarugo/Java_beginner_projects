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
    public boolean enrollStudent(Student student, int course_id) {
        int new_student_id = studentRepo.createStudent(student);

        try {
            con.setAutoCommit(false);
            //Step 1: enroll a student and return the enrollment id.
            ps = con.prepareStatement(SqlQueries.EnrollmentQuery.enrollStudent);
            ps.setInt(1, new_student_id);
            ps.setInt(2, course_id);

            rs = ps.executeQuery();
            rs.next();
            int enrollment_id = rs.getInt("enrollment_id");

            //Step 2: find this course the student has enrolled in, first year first semester
            //Retrieve semester's id.

            ps = con.prepareStatement(SqlQueries.semesterQuery.selectSemesterId);
            ps.setInt(1, course_id);
            rs = ps.executeQuery();
            rs.next();
            int semester_id = rs.getInt("semester_id");


            // Step 3: create the progress record pointing at that semester

            ps = con.prepareStatement(SqlQueries.semesterQuery.createProgress);
            ps.setInt(1, enrollment_id);
            ps.setInt(2, semester_id);
            int rowsAffected =  ps.executeUpdate();

            con.commit(); //All three processes succeeded.
            System.out.println("Student enrolled and started at Year 1, Semester 1.");

            ps.close();
            return true;

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                con.setAutoCommit(true);
            }catch (SQLException e) {
                e.printStackTrace();
            }
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
    public EnrollmentDetails getEnrollmentDetails(int student_id) {

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
