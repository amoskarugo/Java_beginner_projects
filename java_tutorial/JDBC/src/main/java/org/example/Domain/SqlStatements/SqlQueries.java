package org.example.Domain.SqlStatements;

public class SqlQueries {
    private  SqlQueries() {
    }
    public static class StudentQuery {
        private StudentQuery() {
        }
        public static final String createStudentTable =
                "CREATE TABLE IF NOT EXISTS student (id SERIAL PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))";
        public static final String insertIntoStudent =
                "INSERT INTO student VALUES (?, ?)";
        public static final String selectStudentById =
                "SELECT * FROM student WHERE id LIKE ?";
        public static final String selectStudentByEmail =
                "SELECT * FROM student WHERE email LIKE ?";
        public static final String deleteStudentById =
                "DELETE FROM student WHERE id LIKE ?";
        public static final String selectAllStudents =
                "SELECT * FROM student";


    }
}
