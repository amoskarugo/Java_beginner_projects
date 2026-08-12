package org.studentmanagementsystem.Domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Grade {

    public int grade_id;
    public int progress_id;
    public int unit_id;
    public String grade_letter;
    public BigDecimal score;
    public LocalDateTime date_recorded;

    public Grade() {}

    public Grade(int progress_id, int unit_id, String grade_letter, BigDecimal score) {
        this.progress_id = progress_id;
        this.unit_id = unit_id;
        this.grade_letter = grade_letter;
        this.score = score;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getProgress_id() {
        return progress_id;
    }

    public void setProgress_id(int progress_id) {
        this.progress_id = progress_id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getGrade_letter() {
        return grade_letter;
    }

    public void setGrade_letter(String grade_letter) {
        this.grade_letter = grade_letter;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public LocalDateTime getDate_recorded() {
        return date_recorded;
    }

    public void setDate_recorded(LocalDateTime date_recorded) {
        this.date_recorded = date_recorded;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", progress_id=" + progress_id +
                ", unit_id=" + unit_id +
                ", grade_letter='" + grade_letter + '\'' +
                ", score=" + score +
                ", date_recorded=" + date_recorded +
                '}';
    }
}
