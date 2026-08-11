package org.studentmanagementsystem.dto;

import java.time.LocalDateTime;

public class EnrollmentDetails {

    private int enrollment_id;
    private String student_name;
    private int student_id;
    private String course;
    private String status;
    private LocalDateTime enrollment_date;

    public EnrollmentDetails(int enrollment_id, String student_name, int student_id, String course, String status, LocalDateTime enrollment_date) {
        this.enrollment_id = enrollment_id;
        this.student_name = student_name;
        this.student_id = student_id;
        this.course = course;
        this.status = status;
        this.enrollment_date = enrollment_date;
    }

    public int getEnrollment_id() {
        return enrollment_id;
    }

    public void setEnrollment_id(int enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(LocalDateTime enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "EnrollmentDetails{" +
                "enrollment_id=" + enrollment_id +
                ", student_name='" + student_name + '\'' +
                ", student_id=" + student_id +
                ", course='" + course + '\'' +
                ", status='" + status + '\'' +
                ", enrollment_date=" + enrollment_date +
                '}';
    }
}
