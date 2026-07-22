package org.example.service.servicesImpl;

import org.example.Domain.SqlStatements.SqlQueries;
import org.example.Domain.model.Student;
import org.example.config.DatabaseConfig;
import org.example.service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final Connection connection;

    static {
        connection = DatabaseConfig.getDbConnection();
        createStudentTable();
    }
    public StudentServiceImpl() {}
    private static void createStudentTable(){
        try {
            Statement statement = connection.createStatement();
            statement.execute(SqlQueries.StudentQuery.createStudentTable);
            System.out.println("studentTable created");
        } catch (Exception e){
            System.out.println("error creating studentTable" + e.getMessage());
        }
    }
    @Override
    public void createStudent(String name, String email) {

    }

    @Override
    public boolean deleteStudentBtId(int id) {
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return List.of();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }
}
