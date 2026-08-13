package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Unit;
import org.studentmanagementsystem.Repo.impl.CourseRepository;
import org.studentmanagementsystem.dto.CurrentProgress;
import org.studentmanagementsystem.exceptions.StudentNotActive;
import org.studentmanagementsystem.exceptions.UnitsNotFound;
import org.studentmanagementsystem.service.CourseService;

import java.util.ArrayList;
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

    @Override
    public List<Unit> getUnitsBySemester(int semester_id) {
        List<Unit> units = new ArrayList<>();
        units = courseRepository.getUnits(semester_id);
        if (units.isEmpty()) {
            throw new UnitsNotFound("No units with semester " + semester_id);
        }
        return units;
    }

    @Override
    public CurrentProgress getStudentCurrentProgress(int student_id) {
        CurrentProgress currentProgress = courseRepository.getCurrentProgress(student_id);
        if (currentProgress == null) {
            throw new StudentNotActive("This student has no active semester progress.");
        }
        return  currentProgress;
    }
}
