package org.studentmanagementsystem.Domain.SqlStatements;

public class SqlQueries {
    private  SqlQueries() {
    }
    public static class StudentQuery {
        private StudentQuery() {
        }
        public static final String createStudentTable =
                "CREATE TABLE IF NOT EXISTS student (id SERIAL PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))";
        public static final String insertIntoStudent =
                "INSERT INTO student (name, email) VALUES (?, ?) RETURNING id";
        public static final String selectStudentById =
                "SELECT * FROM student WHERE id = ?";
        public static final String deleteStudentById =
                "DELETE FROM student WHERE id = ?";
        public static final String selectAllStudents =
                "SELECT * FROM student";
        public static final String updateStudentById =
                "UPDATE student SET name = ?, email = ? WHERE id = ?";


    }

    public static final class CourseQuery {
        private CourseQuery() {
        }

        public static final String createCourse =
                "INSERT INTO course (name) VALUES (?)";
        public static final String updateCourseById =
                "UPDATE course SET name = ? WHERE id = ?";
        public static final String deleteCourseById =
                "DELETE FROM course WHERE id = ?";
        public static final String selectAllCourses =
                "SELECT * FROM course";
        public  static final String selectCourseById =
                "SELECT * FROM course WHERE id = ?";
    }

    public  static final class EnrollmentQuery{
        private EnrollmentQuery(){}

        public static final String enrollStudent =
                "INSERT INTO enrollement (student_id, course_id) VALUES (?, ?)";
        public

    }
}
