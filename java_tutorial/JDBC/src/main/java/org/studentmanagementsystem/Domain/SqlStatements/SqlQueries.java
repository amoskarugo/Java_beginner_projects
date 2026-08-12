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
                "INSERT INTO enrollement " +
                        "(student_id, course_id)" +
                        " VALUES (?, ?) RETURNING enrollment_id";
        public static final String updateEnrollment =
                "UPDATE enrollement SET status = ? WHERE student_id = ?";

        public static final String studentEnrollmentDetails =  """
                SELECT enrollement.enrollment_id, student.name, student.id, course.course_name, enrollement.status, enrollement.enrollment_date
                FROM student
                JOIN enrollement ON student.id = enrollement.student_id
                JOIN course ON enrollement.course_id = course.id
                WHERE enrollement.student_id = ?""";



    }

    public static final class semesterQuery {
        private semesterQuery(){}

        public static final  String selectSemesterId =
                "SELECT semester_id FROM semester WHERE course_id = ? AND semester_number = 1 AND year_of_study = 1";

        public static final String createProgress =
                "INSERT INTO student_semester_progress (enrollment_id, semester_id, start_date) VALUES (?, ?, CURRENT_DATE)";
        public static final String currentProgress = """
                SELECT ssp.progress_id, ssp.semester_id, s.semester_name
                FROM student_semester_progress ssp
                JOIN enrollement e ON ssp.enrollment_id = e.enrollment_id
                JOIN semester s ON ssp.semester_id = s.semester_id
                WHERE e.student_id = ? AND ssp.status = 'IN_PROGRESS'
                """;



    }
    public static final class GradeQuery {
        private GradeQuery(){}

        public static final String createStudentGrade = """
                INSERT INTO grade (progress_id, unit_id, score, grade_letter) VALUES (?, ?, ?, ?)
                """;
    }
}
