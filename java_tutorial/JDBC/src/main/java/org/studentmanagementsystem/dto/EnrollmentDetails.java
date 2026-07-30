package org.studentmanagementsystem.dto;

public class EnrollmentDetails {

    private Long enrollment_id;
    private Long student_id;
    private String student_name;
    private String course;
    private String status;

    public EnrollmentDetails() {
    }

    public EnrollmentDetails(Long enrollment_id, Long student_id, String student_name, String course, String status) {
        this.enrollment_id = enrollment_id;
        this.student_id = student_id;
        this.student_name = student_name;
        this.course = course;
        this.status = status;
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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
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

    @Override
    public String toString() {
        return "EnrollmentDetails{" +
                "enrollment_id=" + enrollment_id +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", course='" + course + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
