package org.studentmanagementsystem.service;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Unit;
import org.studentmanagementsystem.dto.CurrentProgress;

import java.util.List;

public interface CourseService {

    boolean addCourse(Course course);
    boolean updateCourse(Course course,  int id);
    boolean deleteCourse(int id);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    List<Unit> getUnitsBySemester(int semester_id);
    CurrentProgress getStudentCurrentProgress(int student_id);
}
