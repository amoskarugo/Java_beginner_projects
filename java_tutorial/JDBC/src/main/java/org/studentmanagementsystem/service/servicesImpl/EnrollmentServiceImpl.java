package org.studentmanagementsystem.service.servicesImpl;

import org.studentmanagementsystem.Domain.model.Course;
import org.studentmanagementsystem.Domain.model.Student;
import org.studentmanagementsystem.Repo.impl.EnrollmentRepository;
import org.studentmanagementsystem.Repo.impl.StudentRepository;
import org.studentmanagementsystem.dto.EnrollmentDetails;
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
    public boolean createEnrollment(int student_id, int courseId) {
        return enrollmentRepo.enrollStudent(student_id, courseId);
    }

    @Override
    public boolean updateStudentStatus(Student student, String status) {

        Student updateStudent = studentRepo.getStudentById(student.getId());
        if (updateStudent == null)
            throw new StudentNotFound("The student you are trying to update does not exist!!");
        int success = enrollmentRepo.updateStudentEnrollment(updateStudent.getId(), status);
        return success > 0;
    }

    @Override
    public EnrollmentDetails getStudentEnrollmentDetails(int student_id) {
        EnrollmentDetails enrollmentDetails;
        Student student = studentRepo.getStudentById(student_id);
        if (student == null)
            throw new StudentNotFound("The student details you are trying to get does not exist!!");
        enrollmentDetails = enrollmentRepo.getEnrollmentDetails(student_id);

        return enrollmentDetails;
    }
}
