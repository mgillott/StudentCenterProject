
--gets the students guardian type
select guardian_name from guardian_type
JOIN student_guardian on guardian_type.guardian_type_id = student_guardian.guardian_type_id
JOIN student on student_guardian.guardian_type_id = student.student_id
WHERE student.student_id = 2;

--gets the students guardian information by student id
select guardian.first_name, guardian.last_name, guardian.email_address, guardian.phone_number from guardian
JOIN student_guardian on guardian.guardian_id = student_guardian.guardian_type_id
JOIN student on student_guardian.guardian_type_id = student.student_id
WHERE student.student_id = 2;

--gets teacher by id
SELECT * from teacher where teacher.teacher_id = 1;

--update student grade

--gets the students guardian information by student first name
select guardian.first_name, guardian.last_name, guardian.email_address, guardian.phone_number from guardian
JOIN student_guardian on guardian.guardian_id = student_guardian.guardian_type_id
JOIN student on student_guardian.guardian_type_id = student.student_id
WHERE student.first_name = 'TestKid2';

--gets the subject name from the class_class
select subject_name from subject
JOIN school_class on school_class.subject_id = subject.subject_id
WHERE class_id = 1;

--gets a kids subject_name from subject by students name
select subject.subject_name from subject
JOIN school_class on subject.subject_id = school_class.subject_id
JOIN student_class on student_class.class_id = school_class.class_id
JOIN student on student.student_id = student_class.student_id
WHERE student.first_name = 'TestKid1';

--gets what subjects a teacher teaches by teacher name
select * from teacher
JOIN school_class on school_class.teacher_id = teacher.teacher_id
JOIN subject on school_class.subject_id = subject.subject_id
where teacher.first_name ='TestTeacherFirstName3';

--Shows the period, subject, and name of teacher for all classes a teacher teaches
select school_period.period_name, subject.subject_name, teacher.first_name from school_class
join school_period on school_period.school_period_id = school_class.school_period_id
join subject on subject.subject_id = school_class.subject_id
join teacher on school_class.teacher_id = teacher.teacher_id
where teacher.teacher_id = 1;

--Shows the students schedule
select school_period.period_name, subject.subject_name, teacher.first_name, teacher.last_name from school_class
join school_period on school_period.school_period_id = school_class.school_period_id
join subject on subject.subject_id = school_class.subject_id
join teacher on teacher.teacher_id = school_class.teacher_id
join student_class on student_class.class_id = school_class.class_id
join student on student.student_id = student_class.student_id
where student.student_id = 1;

--This pulls the student rosters for classes based on SUBJECT and PERIOD and (ADD TEACHER FIRST NAME FOR LOGIN SPECIFIC INFORMATION)
select student.first_name, student.last_name, student.gender, student_class.grade from student
join student_class on student_class.student_id = student.student_id
join school_class on school_class.class_id = student_class.class_id
join teacher on teacher.teacher_id = school_class.teacher_id
join school_period on school_period.school_period_id = school_class.school_period_id
join subject on subject.subject_id = school_class.subject_id
where teacher.teacher_id = 1 AND school_period.school_period_id = 1;


--ADD QUERIES
INSERT INTO student (first_name, middle_name, last_name, date_of_birth, gender, enrollment_date)
VALUES ('InsertKid1', 'MiddleNameInsertKid1', 'LastNameInsertKid', '2001-12-02', 'Male', '2024-02-19')
RETURNING student_id;