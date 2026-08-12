package org.studentmanagementsystem.dto;

public class Progress {
    public int progress_id;
    public int semester_id;
    public String semester_name;

    public Progress() {
    }

    public int getProgress_id() {
        return progress_id;
    }

    public void setProgress_id(int progress_id) {
        this.progress_id = progress_id;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getSemester_name() {
        return semester_name;
    }

    public void setSemester_name(String semester_name) {
        this.semester_name = semester_name;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "progress_id=" + progress_id +
                ", semester_id=" + semester_id +
                ", semester_name='" + semester_name + '\'' +
                '}';
    }
}
