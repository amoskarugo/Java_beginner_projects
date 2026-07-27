

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

ALTER TABLE enrollement
DROP CONSTRAINT fk_student;

ALTER TABLE enrollement
    ADD CONSTRAINT fk_student
        FOREIGN KEY (student_id)
            REFERENCES student(id)
            ON DELETE CASCADE;

ALTER TABLE enrollement
DROP CONSTRAINT fk_course;

ALTER TABLE enrollement
    ADD CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES course(id)
            ON DELETE CASCADE;