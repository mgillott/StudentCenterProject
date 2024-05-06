package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Schedule;
import com.techelevator.model.Student;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcStudentDao implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStudentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from student;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Student student = mapToStudent(results);
            students.add(student);
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = new Student();
        String sql = "SELECT * FROM student WHERE student_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            student = mapToStudent(results);
        }
        return student;
    }

    @Override
    public List<Schedule> getStudentScheduleById(int id){
        List<Schedule> studentSchedule = new ArrayList<>();
        String sql = "select school_period.period_name, subject.subject_name, teacher.first_name, teacher.last_name from school_class\n" +
                "join school_period on school_period.school_period_id = school_class.school_period_id\n" +
                "join subject on subject.subject_id = school_class.subject_id\n" +
                "join teacher on teacher.teacher_id = school_class.teacher_id\n" +
                "join student_class on student_class.class_id = school_class.class_id\n" +
                "join student on student.student_id = student_class.student_id\n" +
                "where student.student_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()){
            studentSchedule.add(mapToSchedule(results));
        }
        return studentSchedule;
    }

    @Override
    public Student createStudent(Student student) {
        Student newStudent;
        String sql = "INSERT INTO student (first_name, middle_name, last_name, date_of_birth, gender, enrollment_date) VALUES (?, ?, ?, ?, ?, ?) RETURNING student_id;";

        try{
            int newStudentId = jdbcTemplate.queryForObject(sql, int.class, student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getDateOfBirth(), student.getGender(), student.getEnrollmentDate());
            newStudent = getStudentById(newStudentId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException i) {
            throw new DaoException("Data integrity violation", i);
        }

        return newStudent;
    }

    public Schedule mapToSchedule(SqlRowSet sqlRowSet){
        Schedule schedule = new Schedule();
        schedule.setPeriodName(sqlRowSet.getString("period_name"));
        schedule.setSubjectName(sqlRowSet.getString("subject_name"));
        schedule.setTeacherFirstName(sqlRowSet.getString("first_name"));
        schedule.setTeacherLastName(sqlRowSet.getString("last_name"));
        return schedule;
    }


    public Student mapToStudent(SqlRowSet sqlRowSet) {
        Student student = new Student();
        student.setId(sqlRowSet.getInt("student_id"));
        student.setFirstName(sqlRowSet.getString("first_name"));
        student.setMiddleName(sqlRowSet.getString("last_name"));
        student.setLastName(sqlRowSet.getString("last_name"));
        student.setDateOfBirth(sqlRowSet.getDate("date_of_birth").toLocalDate());
        student.setGender(sqlRowSet.getString("gender"));
        student.setEnrollmentDate(sqlRowSet.getDate("enrollment_date").toLocalDate());
        return student;
    }
}
