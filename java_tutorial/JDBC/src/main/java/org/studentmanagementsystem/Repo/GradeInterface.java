package org.studentmanagementsystem.Repo;

import java.math.BigDecimal;

public interface GradeInterface {
    int createStudentGrade(int progress_id, int unit_id, BigDecimal score, String grade_letter);
}
