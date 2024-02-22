DROP TABLE IF EXISTS student, parent, subject, student_subject_grade, teacher cascade;

CREATE TABLE parent(
    parent_id serial,
    parent_name varchar(50) NOT NULL,
    parent_phone_number int,
    parent_email varchar(50) NOT NULL,
    CONSTRAINT PK_parent PRIMARY KEY (parent_id)
);

CREATE TABLE student(
	student_id serial,
	student_name varchar(50) NOT NULL,
	grade_level varchar(15) NOT NULL,
	parent_id int,
	age int NOT NULL,
	CONSTRAINT PK_student PRIMARY KEY(student_id),
	CONSTRAINT FK_parent FOREIGN KEY (parent_id) REFERENCES parent(parent_id)
);

CREATE TABLE teacher(
    teacher_id serial,
    teacher_name varchar(50) NOT NULL,
    CONSTRAINT PK_teacher PRIMARY KEY (teacher_id)
);

CREATE TABLE subject(
	subject_id serial,
	subject_name varchar(50) NOT NULL,
	teacher_id int,
	CONSTRAINT PK_subject PRIMARY KEY(subject_id),
	CONSTRAINT FK_teacher_subject FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id)
);

CREATE TABLE student_subject_grade(
	student_id int,
	subject_id int,
	CONSTRAINT FK_student_student_subject_grade FOREIGN KEY(student_id) REFERENCES student(student_id),
	CONSTRAINT FK_subject_student_subject_grade FOREIGN KEY(subject_id) REFERENCES subject(subject_id),
	grade float
);

INSERT INTO parent (parent_name, parent_phone_number, parent_email)
VALUES ('Test Parent', 7, 'TestParent@gmail.com');

INSERT INTO student (student_name, grade_level, parent_id, age)
VALUES ('Test Kid', '8th Grade', 1, 13);

INSERT INTO student (student_name, grade_level, parent_id, age)
VALUES ('Test Kid', '7th Grade', 2, 12);

INSERT INTO student (student_name, grade_level, parent_id, age)
VALUES ('Test Kid', '6th Grade', 3, 11);
