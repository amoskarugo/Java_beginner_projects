package org.studentmanagementsystem.Repo.impl;

import org.studentmanagementsystem.Domain.SqlStatements.SqlQueries;
import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Unit;
import org.studentmanagementsystem.Repo.CourseRepoInterface;
import org.studentmanagementsystem.config.DatabaseConfig;
import org.studentmanagementsystem.dto.CurrentProgress;
import org.studentmanagementsystem.exceptions.CourseNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements CourseRepoInterface {

    private static final Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;
    static{
        connection = DatabaseConfig.getDbConnection();
    }
    @Override
    public int createCourse(Course course) {
        int rowsAffected = 0;
        try {
            ps = connection.prepareStatement(SqlQueries.CourseQuery.createCourse);
            ps.setString(1, course.getCourseName());
            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;
        }catch (SQLException e){
            System.out.println("SQL Error, failed to create course " + e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int deleteCourse(int id) {
        int rowsAffected = 0;
        if (getCourseById(id) == null) {
            throw new CourseNotFoundException("Course with id " + id + " does not exist");
        }
        try {
            ps = connection.prepareStatement(SqlQueries.CourseQuery.deleteCourseById);
            ps.setInt(1, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;

        }    catch (SQLException e){
            System.out.println("Something went wrong, failed to delete course  " + "Error message" + e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public int updateCourse(Course course, int id) {
        int rowsAffected = 0;
        if (getCourseById(id) == null) {
            throw new CourseNotFoundException("course was not found!!!");
        }
        try {
            ps = connection.prepareStatement(SqlQueries.CourseQuery.updateCourseById);
            ps.setString(1, course.getCourseName());
            ps.setInt(2, id);
            rowsAffected = ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            System.out.println("SQL Error, failed to update course  " + e.getMessage());
        }
        return rowsAffected;
    }

    @Override
    public Course getCourseById(int id) {
        Course course = null;
        try {
            ps = connection.prepareStatement(SqlQueries.CourseQuery.selectCourseById);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                course = new Course(rs.getInt("id"),rs.getString("name"));
            }
            rs.close();
            ps.close();
            return course;
        } catch (SQLException e) {
            System.out.println("Failed to get course with id " + id + "Error message " + e.getMessage());
        }
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            ps=connection.prepareStatement(SqlQueries.CourseQuery.selectAllCourses);

            rs=ps.executeQuery();
            while(rs.next()) {
                courses.add(new Course(rs.getInt("id"),rs.getString("course_name")));
            }
            rs.close();
            ps.close();
            return courses;
        }catch (Exception e) {
            System.out.println("retrieving all courses operation failed!!! " + "Error message " + e.getMessage());
}
        return courses;
    }
    @Override
    public CurrentProgress getCurrentProgress(int studentId) {
        CurrentProgress progress = null;

        try {
            ps = connection.prepareStatement(SqlQueries.semesterQuery.currentProgress);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();
            while(rs.next()) {
                progress = new CurrentProgress();
                progress.setProgress_id(rs.getInt("progress_id"));
                progress.setSemester_id(rs.getInt("semester_id"));
                progress.setSemester_name(rs.getString("semester_name"));
            }
            rs.close();

        }catch (SQLException e) {
            System.out.println("getting current progress operation failed!!! " + "Error message: " + e.getMessage());
        }
        return progress;
    }
    @Override
    public List<Unit> getUnits(int semester_id) {
        List<Unit> units  = new ArrayList<>();

        try {
            ps = connection.prepareStatement(SqlQueries.semesterQuery.selectAllUnitsBySemesterId);
            ps.setInt(1, semester_id);
            rs = ps.executeQuery();
            while(rs.next()) {
                Unit unit = new Unit();
                unit.setUnit_id(rs.getInt("unit_id"));
                unit.setSemester_id(rs.getInt("semester_id"));
                unit.setUnit_name(rs.getString("unit_name"));
                units.add(unit);
            }
            rs.close();
            ps.close();
        }catch (SQLException e){
            System.out.println("getting current unit operation failed!!! " +  e.getMessage());
        }
        return units;
    }
}
