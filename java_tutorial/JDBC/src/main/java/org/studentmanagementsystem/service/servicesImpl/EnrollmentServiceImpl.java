package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Repo.impl.EnrollmentRepository;
import org.studentmanagementsystem.Repo.impl.StudentRepository;
import org.studentmanagementsystem.exceptions.StudentNotFound;
import org.studentmanagementsystem.service.EnrollmentService;

public class EnrollmentServiceImpl implements EnrollmentService {
    CourseServiceImpl courseService;
    EnrollmentRepository enrollmentRepo;
    StudentRepository studentRepo;

    public EnrollmentServiceImpl() {
        this.courseService = new CourseServiceImpl();
        this.enrollmentRepo = new EnrollmentRepository();
        this.studentRepo = new StudentRepository();
    }

    @Override
    public boolean createEnrollment(Student student, int courseId) {
        Course new_course = courseService.getCourseById(courseId);
        int student_enrolled = enrollmentRepo.enrollStudent(student, courseId);
        return student_enrolled > 0;
    }

    @Override
    public boolean updateStudentStatus(Student student, String status) {

        Student updateStudent = studentRepo.getStudentById(student.getId());
        if (updateStudent == null)
            throw new StudentNotFound("The student you are trying to update does not exist!!");
        int success = enrollmentRepo.updateStudentEnrollment(updateStudent.getId(), status);
        return success > 0;
    }
}
