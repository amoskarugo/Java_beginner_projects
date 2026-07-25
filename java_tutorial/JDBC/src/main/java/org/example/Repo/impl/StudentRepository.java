package org.example.Repo.impl;

import org.example.Domain.SqlStatements.SqlQueries;
import org.example.Domain.model.Student;
import org.example.Repo.StudentRepoInterface;
import org.example.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements StudentRepoInterface {

    private static final Connection con = DatabaseConfig.getDbConnection();
    private static PreparedStatement ps;

    @Override
    public int createStudent(Student student) {
        int rowsAffected = 0;
        try {
            ps = con.prepareStatement(SqlQueries.StudentQuery.insertIntoStudent);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;
        }catch (SQLException e){
            System.out.println("Error in creating new student");
        }
        return rowsAffected;
    }

    @Override
    public int updateStudentById(int id) {
        int rowsAffected = 0;
        try {
            ps = con.prepareStatement(SqlQueries.StudentQuery.updateStudentById);
            ps.setInt(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;
        }catch (SQLException e){
            System.out.println("Error updating student with id " + id);
        }
        return rowsAffected;
    }

    @Override
    public int deleteStudent(int id) {
        int rowsAffected = 0;
        try {
            ps = con.prepareStatement(SqlQueries.StudentQuery.deleteStudentById);
            ps.setInt(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;
        }catch (SQLException e){
            System.out.println("failed to student with id "+ id);
        }
        return rowsAffected;
    }

    @Override
    public Student getStudent(int id) {
        Student student = null;
        try {
            ps = con.prepareStatement(SqlQueries.StudentQuery.selectStudentById);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                student = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error fetching student with id " + id);
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {

        ArrayList<Student> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(SqlQueries.StudentQuery.selectAllStudents);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")));
            }
            rs.close();

        }catch (SQLException e){
            System.out.println("Error in fetching all students");
        }
        return list;
    }
}
