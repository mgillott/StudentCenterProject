package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.StudentGrade;
import com.techelevator.model.Teacher;
import com.techelevator.model.TeacherRoster;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
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
    public Teacher getTeacherById(int id){
        Teacher teacher = new Teacher();
        String sql = "SELECT * from teacher where teacher.teacher_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            teacher = mapToTeacher(results);
        }
        return teacher;
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

    @Override
    public TeacherRoster getTeacherRosterByPeriod(int teacherId, int periodId) {
        TeacherRoster teacherRoster = new TeacherRoster();
        String sql = "select student.first_name, student.last_name, student.gender, student_class.grade from student\n" +
                "join student_class on student_class.student_id = student.student_id\n" +
                "join school_class on school_class.class_id = student_class.class_id\n" +
                "join teacher on teacher.teacher_id = school_class.teacher_id\n" +
                "join school_period on school_period.school_period_id = school_class.school_period_id\n" +
                "join subject on subject.subject_id = school_class.subject_id\n" +
                "where teacher.teacher_id = ? AND school_period.school_period_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teacherId, periodId);
        if(results.next()){
            teacherRoster = mapToTeacherRoster(results);
        }
        return teacherRoster;
    }

    @Override
    public StudentGrade getStudentGradeById(int studentId, int classId){
        StudentGrade studentGrade = new StudentGrade();
        String sql = "select grade, student_id, class_id from student_class where student_id = ? and class_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, studentId, classId);
        if(results.next()){
            studentGrade.setLetterGrade(results.getString("grade"));
            studentGrade.setStudentId(results.getInt("student_id"));
            studentGrade.setClassId(results.getInt("class_id"));
        }
        return studentGrade;
    }

    @Override
    public StudentGrade updateTeacherClassGrade(StudentGrade studentGrade){
        StudentGrade updatedStudentGrade = null;
        String sql = "UPDATE student_class SET grade = ? where student_id = ? AND class_id = ?;";
        try{
            jdbcTemplate.update(sql, studentGrade.getLetterGrade(), studentGrade.getStudentId(), studentGrade.getClassId());
            updatedStudentGrade = getStudentGradeById(studentGrade.getStudentId(), studentGrade.getClassId());
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e){
            throw new DaoException("Data integrity violation", e);
        }
        return updatedStudentGrade;
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

    private TeacherRoster mapToTeacherRoster(SqlRowSet results) {
        TeacherRoster teacherRoster = new TeacherRoster();
        teacherRoster.setStudentName(results.getString("first_name"));
        teacherRoster.setStudentLastName(results.getString("last_name"));
        teacherRoster.setGender(results.getString("gender"));
        teacherRoster.setGrade(results.getString("grade"));
        return teacherRoster;
    }
}
