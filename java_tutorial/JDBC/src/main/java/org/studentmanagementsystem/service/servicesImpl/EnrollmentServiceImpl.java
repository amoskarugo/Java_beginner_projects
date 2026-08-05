package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Repo.impl.EnrollmentRepository;
import org.studentmanagementsystem.service.EnrollmentService;

public class EnrollmentServiceImpl implements EnrollmentService {
    CourseServiceImpl courseService;
    EnrollmentRepository enrollmentRepo;

    public EnrollmentServiceImpl() {
        this.courseService = new CourseServiceImpl();
        this.enrollmentRepo = new EnrollmentRepository();
    }

    @Override
    public boolean createEnrollment(Student student, int courseId) {
        Course new_course = courseService.getCourseById(courseId);
        int student_enrolled = enrollmentRepo.enrollStudent(student, courseId);
        return student_enrolled > 0;
    }
}
