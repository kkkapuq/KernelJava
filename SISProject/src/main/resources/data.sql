-- 예제 데이터 삽입
-- 과목 추가
INSERT INTO subject (id, name, grade_type) VALUES (1, '국어', 0);
INSERT INTO subject (id, name, grade_type) VALUES (2, '수학', 0);
INSERT INTO subject (id, name, grade_type) VALUES (3, '방송댄스', 2);

-- 학생 추가
INSERT INTO student (id, name, major_subject) values (1, '조형준', '국어');
INSERT INTO student (id, name, major_subject) values (2, '문찬욱', '수학');
INSERT INTO student (id, name, major_subject) values (3, '신종민', '국어');
INSERT INTO student (id, name, major_subject) values (4, '안소현', '수학');
INSERT INTO student (id, name, major_subject) values (5, '우무룡', '수학');
INSERT INTO student (id, name, major_subject) values (201290, '김현지', '수학');
INSERT INTO student (id, name, major_subject) values (202360, '이윤선', '국어');
INSERT INTO student (id, name, major_subject) values (201518, '정지용', '국어');
INSERT INTO student (id, name, major_subject) values (212330, '우무룡', '수학');
INSERT INTO student (id, name, major_subject) values (211213, '김영롱', '국어');



-- 점수 추가
INSERT INTO score (id, student_id, subject_id, point) values (1, 1, 1, 90);
INSERT INTO score (id, student_id, subject_id, point) values (2, 1, 2, 80);
INSERT INTO score (id, student_id, subject_id, point) values (3, 1, 3, 60);
INSERT INTO score (id, student_id, subject_id, point) values (4, 2, 2, 90);
INSERT INTO score (id, student_id, subject_id, point) values (5, 3, 1, 90);
INSERT INTO score (id, student_id, subject_id, point) values (6, 4, 2, 50);
INSERT INTO score (id, student_id, subject_id, point) values (7, 4, 3, 100);
INSERT INTO score (id, student_id, subject_id, point) values (8, 5, 2, 100);
INSERT INTO score (id, student_id, subject_id, point) values (9, 5, 3, 100);
INSERT INTO score (id, student_id, subject_id, point) values (10, 201290, 1, 83);
INSERT INTO score (id, student_id, subject_id, point) values (11, 201290, 2, 56);
INSERT INTO score (id, student_id, subject_id, point) values (12, 202360, 1, 89);
INSERT INTO score (id, student_id, subject_id, point) values (13, 202360, 2, 95);
INSERT INTO score (id, student_id, subject_id, point) values (14, 201518, 1, 100);
INSERT INTO score (id, student_id, subject_id, point) values (15, 201518, 2, 88);
INSERT INTO score (id, student_id, subject_id, point) values (16, 212330, 1, 95);
INSERT INTO score (id, student_id, subject_id, point) values (17, 212330, 2, 98);
INSERT INTO score (id, student_id, subject_id, point) values (18, 211213, 1, 95);
INSERT INTO score (id, student_id, subject_id, point) values (19, 211213, 2, 56);