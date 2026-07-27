package org.example.Domain.model;

public class Course {

    private Integer id;
    private String name;

    public Course(Integer courseId, String courseName) {
        this.id = courseId;
        this.name = courseName;
    }

    public Course(String courseName) {
        this.name = courseName;
    }


    public Integer getCourseId() {
        return id;
    }

    public void setCourseId(Integer courseId) {
        this.id = courseId;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String courseName) {
        this.name = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + id +
                ", courseName='" + name + '\'' +
                '}';
    }
}
