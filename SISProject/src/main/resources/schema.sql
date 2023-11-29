CREATE TABLE IF NOT EXISTS student
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(255) NOT NULL,
    major_subject VARCHAR(255) NOT NULL,
    school_id     INT
);

CREATE TABLE IF NOT EXISTS subject
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(255) NOT NULL,
    grade_type INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS score
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    subject_id INT,
    point      INT         NOT NULL,
    CONSTRAINT fk_student
        FOREIGN KEY (student_id)
            REFERENCES student (id),
    CONSTRAINT fk_subject
        FOREIGN KEY (subject_id)
            REFERENCES subject (id)
);