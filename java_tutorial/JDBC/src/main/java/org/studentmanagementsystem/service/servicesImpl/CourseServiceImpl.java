package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Repo.impl.CourseRepository;
import org.studentmanagementsystem.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private static final CourseRepository courseRepository;


    static {
        courseRepository = new CourseRepository();
    }

    @Override
    public boolean addCourse(Course course) {
        return courseRepository.createCourse(course) > 0 ;
    }

    @Override
    public boolean updateCourse(Course course, int id) {
        return courseRepository.updateCourse(course, id) > 0;
    }

    @Override
    public boolean deleteCourse(int id) {
        return courseRepository.deleteCourse(id) > 0;
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.
                getAllCourses();
    }
}
