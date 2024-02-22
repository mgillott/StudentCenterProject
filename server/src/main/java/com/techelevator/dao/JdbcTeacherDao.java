package com.techelevator.dao;

import com.techelevator.model.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeacherDao implements TeacherDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTeacherDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "select * from teacher;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Teacher teacher = mapToTeacher(results);
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public Teacher getTeacherScheduleById(int id) {
        Teacher teacher = new Teacher();
        String sql = "select school_period.period_name, subject.subject_name, teacher.first_name from school_class\n" +
                "join school_period on school_period.school_period_id = school_class.school_period_id\n" +
                "join subject on subject.subject_id = school_class.subject_id\n" +
                "join teacher on school_class.teacher_id = teacher.teacher_id\n" +
                "where teacher.teacher_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            teacher = mapToTeacherSchedule(results);
        }
        return teacher;
    }

    public Teacher mapToTeacher(SqlRowSet sqlRowSet) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(sqlRowSet.getInt("teacher_id"));
        teacher.setTeacherFirstName(sqlRowSet.getString("first_name"));
        teacher.setTeacherLastName(sqlRowSet.getString("last_name"));
        teacher.setTeacherGender(sqlRowSet.getString("gender"));
        teacher.setTeacherEmail(sqlRowSet.getString("email_address"));
        teacher.setTeacherPhoneNumber(sqlRowSet.getInt("phone_number"));
        return teacher;
     }

    private Teacher mapToTeacherSchedule(SqlRowSet results) {
        Teacher teacher = new Teacher(); //using specific teacher constructor
        teacher.setPeriod(results.getString("period_name"));
        teacher.setSubject(results.getString("subject_name"));
        teacher.setTeacherFirstName(results.getString("first_name"));
        return teacher;
    }
}
