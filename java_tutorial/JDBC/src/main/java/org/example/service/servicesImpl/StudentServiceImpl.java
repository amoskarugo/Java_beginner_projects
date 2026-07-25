package org.example.service.servicesImpl;

import org.example.Domain.SqlStatements.SqlQueries;
import org.example.Domain.model.Student;
import org.example.config.DatabaseConfig;
import org.example.service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    public ResultSet resultSet;

    static {
        connection = DatabaseConfig.getDbConnection();
//        createStudentTable();
    }
    public StudentServiceImpl() {}
    private static void createStudentTable(){
        try {
            statement = connection.createStatement();
            statement.execute(SqlQueries.StudentQuery.createStudentTable);
            System.out.println("studentTable created");
        } catch (Exception e){
            System.out.println("error creating studentTable" + e.getMessage());
        }
    }
    @Override
    public void createStudent(String name, String email) {
        try {
            preparedStatement = connection.prepareStatement(SqlQueries.StudentQuery.insertIntoStudent);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            System.out.println("student created");
        }catch(SQLException e){
            System.out.println("error creating student" + e.getMessage());
        }
    }

    @Override
    public boolean deleteStudentById(int id) {
        try {
            preparedStatement = connection.prepareStatement(SqlQueries.StudentQuery.deleteStudentById);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        }catch(SQLException e){
            System.out.println("error deleting student" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement(SqlQueries.StudentQuery.selectAllStudents);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                studentList.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")));
            }
            resultSet.close();
        }catch(SQLException e){
            System.out.println("error selecting students" + e.getMessage());
        }
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = null;
        try {
            preparedStatement = connection.prepareStatement(SqlQueries.StudentQuery.selectStudentById);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = new Student(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("email"));

            }
            resultSet.close();
        }catch(SQLException e){
            System.out.println("error getting student " + e.getMessage());
        }
        return student;
    }

    @Override
    public boolean updateStudentById(int id, String name, String email) {
        try {
            preparedStatement = connection.prepareStatement(SqlQueries.StudentQuery.updateStudentById);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rowsAffected > 0;
        }catch(SQLException e){
            System.out.println("error updating student " + e.getMessage());
        }
        return false;
    }
}
