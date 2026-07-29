package org.studentmanagementsystem.Domain.model;

import java.time.LocalDateTime;

public class Enrollment {

    private Long enrollment_id;
    private Long student_id;
    private Long course_id;
    private LocalDateTime enrollment_date;
    private String status;

    public Enrollment(){}

    public Enrollment(LocalDateTime enrollment_date, Long enrollment_id, Long student_id, Long course_id, String status) {
        this.enrollment_date = enrollment_date;
        this.enrollment_id = enrollment_id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.status = status;
    }

    public Enrollment(Long course_id, Long student_id) {
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public Long getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(Long enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public LocalDateTime getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(LocalDateTime enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollment_id=" + enrollment_id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", enrollment_date=" + enrollment_date +
                ", status='" + status + '\'' +
                '}';
    }
}
