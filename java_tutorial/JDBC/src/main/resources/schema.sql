

CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE
);


CREATE TABLE IF NOT EXISTS course(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS enrollement(
    enrollment_id SERIAL PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
        CONSTRAINT fk_student
          FOREIGN KEY (student_id)
            REFERENCES student (id),
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES course(id)
);

-- ALTER TABLE enrollement
-- DROP CONSTRAINT fk_student;
--
-- ALTER TABLE enrollement
--     ADD CONSTRAINT fk_student
--         FOREIGN KEY (student_id)
--             REFERENCES student(id)
--             ON DELETE CASCADE;
--
-- ALTER TABLE enrollement
-- DROP CONSTRAINT fk_course;

-- ALTER TABLE enrollement
--     ADD CONSTRAINT fk_course
--         FOREIGN KEY (course_id)
--             REFERENCES course(id)
--             ON DELETE CASCADE;


CREATE TABLE IF NOT EXISTS semester (
    semester_id SERIAL PRIMARY KEY,
    course_id INT NOT NULL,
    semester_number INT NOT NULL CHECK (semester_number BETWEEN 1 AND 2),   -- e.g. 1, 2, 3
    year_of_study INT NOT NULL CHECK (year_of_study BETWEEN 1 AND 2),      -- e.g. "Semester 1" or "Fall Year 1"
    CONSTRAINT fk_course
     FOREIGN KEY (course_id)
         REFERENCES course(id)
            ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS unit (
    unit_id SERIAL PRIMARY KEY,
    semester_id INT NOT NULL,
    unit_name VARCHAR(100) UNIQUE,
    CONSTRAINT fk_semester
        FOREIGN KEY (semester_id)
            REFERENCES semester(semester_id)
                ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS student_semester_progress (
     progress_id SERIAL PRIMARY KEY,
     enrollment_id INT NOT NULL,
     semester_id INT NOT NULL,
     start_date DATE NOT NULL,
     completion_date DATE GENERATED ALWAYS AS ((start_date + INTERVAL '3 months')::DATE) STORED,
     status VARCHAR(20) DEFAULT 'IN_PROGRESS', -- COMPLETED
        CONSTRAINT fk_enrollment
            FOREIGN KEY (enrollment_id)
                REFERENCES enrollement(enrollment_id)
                    ON DELETE CASCADE,
        CONSTRAINT fk_semester
            FOREIGN KEY (semester_id)
                REFERENCES semester(semester_id)
                    ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS grade (
    grade_id SERIAL PRIMARY KEY,
    unit_id INT NOT NULL,
    progress_id INT NOT NULL,
    score NUMERIC(5,2),
    grade_letter VARCHAR(2) NOT NULL,
    date_recorded TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        CONSTRAINT fk_progress
                                 FOREIGN KEY (progress_id)
                                 REFERENCES student_semester_progress(progress_id)
                                 ON DELETE CASCADE,
        CONSTRAINT fk_unit
                                 FOREIGN KEY (unit_id)
                                 REFERENCES unit(unit_id)
                                 ON DELETE CASCADE,
        CONSTRAINT unique_grade_per_unit_per_attempt
                                 UNIQUE (unit_id, progress_id)
);