DROP TABLE IF EXISTS app_user, student, student_year_level, student_guardian, guardian_type, guardian, teacher, subject, student_class, school_class, classroom, room_type, school_period CASCADE;

CREATE TABLE app_user (
	user_id serial,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	display_name varchar(50),
	img_url varchar(500),
	short_bio varchar(500),
	CONSTRAINT PK_app_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE student (
	student_id serial,
	first_name varchar(50) NOT NULL,
	middle_name varchar(50),
	last_name varchar(50) NOT NULL,
	date_of_birth DATE NOT NULL,
	gender varchar(15) NOT NULL,
	enrollment_date DATE NOT NULL,
	CONSTRAINT PK_student PRIMARY KEY (student_id)
);

CREATE TABLE student_year_level (
	student_id int,
	level_id int,
	school_year int,
	grade int,
	CONSTRAINT FK_student_year_level_student FOREIGN KEY(student_id) REFERENCES student(student_id)
);

CREATE TABLE guardian_type (
	guardian_type_id serial,
	guardian_name varchar(50),
	CONSTRAINT PK_guardian_type PRIMARY KEY(guardian_type_id)
);

CREATE TABLE guardian (
	guardian_id serial,
	first_name varchar(50),
	last_name varchar(50),
	email_address varchar(50),
	phone_number int,
	CONSTRAINT PK_guardian PRIMARY KEY(guardian_id)
);

CREATE TABLE student_guardian (
	student_id int,
	guardian_type_id int,
	guardian_id int,
	CONSTRAINT FK_student_guardian_student FOREIGN KEY(student_id) REFERENCES student(student_id),
	CONSTRAINT FK_student_guardian_guardian_type FOREIGN KEY(guardian_type_id) REFERENCES guardian_type(guardian_type_id)
);

CREATE TABLE subject (
	subject_id int,
	subject_name varchar(50),
	CONSTRAINT PK_subject PRIMARY KEY(subject_id)
);

CREATE TABLE teacher (
	teacher_id int,
	teacher_subject varchar(50),
	first_name varchar(50),
	last_name varchar(50),
	gender varchar(50),
	email_address varchar(50),
	phone_number int,
	CONSTRAINT PK_teacher PRIMARY KEY(teacher_id)
);

CREATE TABLE school_class (
	class_id int,
	subject_id int,
	teacher_id int,
	term_id int,
	school_period_id int,
	classroom_id int,
	CONSTRAINT PK_school_class PRIMARY KEY(class_id),
	CONSTRAINT FK_school_class_subject FOREIGN KEY(subject_id) REFERENCES subject(subject_id),
	CONSTRAINT FK_school_class_teacher FOREIGN KEY(teacher_id) REFERENCES teacher(teacher_id)
);

CREATE TABLE student_class (
	student_id int,
	class_id int,
	CONSTRAINT FK_student_class_student FOREIGN KEY(student_id) REFERENCES student(student_id),
	CONSTRAINT FK_sudent_class_school_class FOREIGN KEY(class_id) REFERENCES school_class(class_id)
);

CREATE TABLE room_type (
	room_type_id int,
	room_name varchar(50),
	CONSTRAINT PK_room_type PRIMARY KEY (room_type_id)
);

CREATE TABLE classroom (
	classroom_id int,
	room_type_id int,
	room_number int,
	capacity int,
	CONSTRAINT PK_classroom PRIMARY KEY (classroom_id),
	CONSTRAINT FK_classroom_room_type FOREIGN KEY (room_type_id) REFERENCES room_type(room_type_id)
);

CREATE TABLE school_period (
	school_period_id int,
	school_year_id int,
	start_time time,
	end_time time,
	period_name varchar(25)
);

INSERT INTO STUDENT (first_name, middle_name, last_name, date_of_birth, gender, enrollment_date)
VALUES ('TestKid1', 'MiddleNameTestKid1', 'LastNameTestKid1', '1993-12-02', 'Male', '2024-2-19');
INSERT INTO STUDENT (first_name, middle_name, last_name, date_of_birth, gender, enrollment_date)
VALUES ('TestKid2', 'MiddleNameTestKid2', 'LastNameTestKid2', '1994-12-02', 'Female', '2024-1-19');
INSERT INTO STUDENT (first_name, middle_name, last_name, date_of_birth, gender, enrollment_date)
VALUES ('TestKid3', 'MiddleNameTestKid3', 'LastNameTestKid3', '1995-12-02', 'Male', '2024-3-19');

INSERT INTO guardian_type (guardian_name)
VALUES ('Mother');
INSERT INTO guardian_type (guardian_name)
VALUES ('Gradparent');
INSERT INTO guardian_type (guardian_name)
VALUES ('Father');

INSERT INTO guardian (first_name, last_name, email_address, phone_number)
VALUES ('TestParentFirstName1', 'TestParentLastName1', 'TestParentEmail1', 1);
INSERT INTO guardian (first_name, last_name, email_address, phone_number)
VALUES ('TestParentFirstName2', 'TestParentLastName2', 'TestParentEmail2', 2);
INSERT INTO guardian (first_name, last_name, email_address, phone_number)
VALUES ('TestParentFirstName3', 'TestParentLastName3', 'TestParentEmail3', 3);

INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (1, 'Math','MathTeacherFirstName','MathTeacherLastName', 'Male', 'MathTeacher1Email', 1);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (2, 'Science','ScienceTeacherFirstName', 'ScienceTeacherLastName', 'Femail', 'ScienceTeacher2Email', 2);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (3, 'English', 'FirstEnglishTeacherFirstName', 'FirstEnglishTeacherTeacherLastName', 'Female', 'FirstEnglishTeacherEmail', 3);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (4, 'English', 'SecondEnglishTeacherFirstName', 'SecondEnglishTeacherTeacherLastName', 'Male', 'SecondEnglishTeacherEmail', 4);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (5, 'Gym', 'GymTeacherFirstName', 'GymTeacherTeacherLastName', 'Male', 'GymTeacherEmail', 5);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (6, 'Music', 'MusicTeacherFirstName', 'MusicTeacherTeacherLastName', 'Male', 'MusicTeacherEmail', 6);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (7, 'History', 'FirstHistoryTeacherFirstName', 'FirstHistoryTeacherTeacherLastName', 'Female', 'FirstHistoryTeacherEmail', 7);
INSERT INTO teacher (teacher_id, teacher_subject, first_name, last_name, gender, email_address, phone_number)
VALUES (8, 'History', 'SecondHistoryTeacherFirstName', 'SecondHistoryTeacherTeacherLastName', 'Female', 'SecondHistoryTeacherEmail', 8);

INSERT INTO student_guardian(student_id, guardian_type_id, guardian_id)
VALUES (1,1,1);
INSERT INTO student_guardian(student_id, guardian_type_id, guardian_id)
VALUES (2,2,2);
INSERT INTO student_guardian(student_id, guardian_type_id, guardian_id)
VALUES (3,3,3);

INSERT INTO student_year_level(student_id)
VALUES (1);

INSERT INTO subject(subject_id, subject_name)
VALUES (1, 'Math');
INSERT INTO subject(subject_id, subject_name)
VALUES (2, 'Science');
INSERT INTO subject(subject_id, subject_name)
VALUES (3, 'English');
INSERT INTO subject(subject_id, subject_name)
VALUES (4, 'Gym');
INSERT INTO subject(subject_id, subject_name)
VALUES (5, 'Music');
INSERT INTO subject(subject_id, subject_name)
VALUES (6, 'History');

INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (1, 1, 1, 1);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (2, 1, 1, 2);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (3, 2, 2, 2);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (4, 2, 2, 1);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (5, 3, 3, 3);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (6, 3, 4, 3);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (7, 4, 5, 4);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (8, 5, 6, 4);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (9, 5, 6, 6);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (10, 4, 5, 6);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (11, 6, 7, 7);
INSERT INTO school_class(class_id, subject_id, teacher_id, school_period_id)
VALUES (12, 6, 8, 7);

INSERT INTO student_class(student_id, class_id)
VALUES(1, 1);
INSERT INTO student_class(student_id, class_id)
VALUES(1, 3);
INSERT INTO student_class(student_id, class_id)
VALUES(1, 5);
INSERT INTO student_class(student_id, class_id)
VALUES(1, 7);
INSERT INTO student_class(student_id, class_id)
VALUES(1, 9);
INSERT INTO student_class(student_id, class_id)
VALUES(1, 11);
INSERT INTO student_class(student_id, class_id)
VALUES(2, 4);
INSERT INTO student_class(student_id, class_id)
VALUES(2, 2);
INSERT INTO student_class(student_id, class_id)
VALUES(2, 6);
INSERT INTO student_class(student_id, class_id)
VALUES(2, 8);
INSERT INTO student_class(student_id, class_id)
VALUES(2, 10);
INSERT INTO student_class(student_id, class_id)
VALUES(2, 12);

INSERT INTO room_type (room_type_id, room_name)
VALUES(1, 'GenMathRoom');
INSERT INTO room_type (room_type_id, room_name)
VALUES(2, 'GenScienceRoom');
INSERT INTO room_type (room_type_id, room_name)
VALUES(3, 'GenMusicRoom');

INSERT INTO classroom (classroom_id, room_type_id, room_number, capacity)
VALUES (1, 1, 101, 30);
INSERT INTO classroom (classroom_id, room_type_id, room_number, capacity)
VALUES (2, 1, 102, 30);
INSERT INTO classroom (classroom_id, room_type_id, room_number, capacity)
VALUES (3, 2, 103, 30);

INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (1, 2024, 'First Period');
INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (2, 2024, 'Second Period');
INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (3, 2024, 'Third Period');
INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (4, 2024, 'Fourth Period');
INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (5, 2024, 'Fifth Period');
INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (6, 2024, 'Sixth Period');
INSERT INTO school_period (school_period_id, school_year_id, period_name)
VALUES (7, 2024, 'Seventh Period');

INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', null, null, null);
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('job_coach','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Imani',
		'https://source.boringavatars.com/bauhaus/80/job_coach',
		'Career coach, specializing in working with students fresh out of college and career changers, with a special interest in technology roles.');
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('newbie_coder','$2a$10$We8.y4IV/uQOPT1crppxR.aASgeKFr24ISrkHcqWWSYlxRu4oeqE6','ROLE_USER', null,
		'https://source.boringavatars.com/beam/80/newbie_coder',
		'New parent turned coder, with a passion for basketball, stats, and a good laugh.');
INSERT INTO app_user (username, password_hash, role, display_name, img_url, short_bio)
	VALUES ('troublemaker','$2a$10$K/XxMq03OaJM4AhLU7YE3eQh1KAd8/gzWIOWLgBqVrb5AoSy.pmSK','ROLE_USER', null, null, null);

select student.first_name, student.last_name, student.gender, teacher.first_name from student 
join student_class on student_class.student_id = student.student_id
join school_class on school_class.class_id = student_class.class_id
join teacher on teacher.teacher_id = school_class.teacher_id
join school_period on school_period.school_period_id = school_class.school_period_id
join subject on subject.subject_id = school_class.subject_id
where subject.subject_name = 'Math' AND school_period.period_name = 'First Period';

