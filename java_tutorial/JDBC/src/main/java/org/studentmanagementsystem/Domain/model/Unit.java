package org.studentmanagementsystem.Domain.model;

public class Unit {
    public int unit_id;
    public int semester_id;
    public String unit_name;

    public Unit() {
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unit_id=" + unit_id +
                ", semester_id=" + semester_id +
                ", unit_name='" + unit_name + '\'' +
                '}';
    }
}
