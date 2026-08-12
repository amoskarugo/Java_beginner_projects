package org.studentmanagementsystem.Repo.impl;

import org.studentmanagementsystem.Domain.SqlStatements.SqlQueries;
import org.studentmanagementsystem.Repo.GradeInterface;
import org.studentmanagementsystem.config.DatabaseConfig;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GradeRepository implements GradeInterface {

    public static final Connection con;
    public PreparedStatement ps;

    static{
        con = DatabaseConfig.getDbConnection();
    }
    @Override
    public int createStudentGrade(int progress_id, int unit_id, BigDecimal score, String grade_letter) {
        int rowsAffected = 0;

        try {
            ps = con.prepareStatement(SqlQueries.GradeQuery.createStudentGrade);
            ps.setInt(1, progress_id);
            ps.setInt(2, unit_id);
            ps.setBigDecimal(3, score);
            ps.setString(4, grade_letter);

            rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;

        }catch(SQLException e){
            if ("23505".equals(e.getSQLState())) { // unique violation
                System.out.println("A grade for this unit already exists — use update instead.");
            } else {
                System.out.println("error creating grade: " + e.getMessage());
            }
            return 0;
        }
    }
}
