package org.example.Repo;

import org.example.Domain.model.Course;

import java.util.List;

public interface CourseRepoInterface {

    int createCourse(Course course);
    int deleteCourse(int id);
    int updateCourse(Course course,  int id);
    Course getCourseById(int id);
    List<Course> getAllCourses();
}
