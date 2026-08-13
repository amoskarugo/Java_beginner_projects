package org.studentmanagementsystem.Repo;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Unit;
import org.studentmanagementsystem.dto.CurrentProgress;

import java.util.List;

public interface CourseRepoInterface {

    int createCourse(Course course);
    int deleteCourse(int id);
    int updateCourse(Course course,  int id);
    Course getCourseById(int id);
    List<Course> getAllCourses();
    CurrentProgress getCurrentProgress(int studentId);
    List<Unit> getUnits(int semester_id);
}
