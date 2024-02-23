package com.techelevator.dao;

import com.techelevator.model.StudentGrade;
import com.techelevator.model.Teacher;
import com.techelevator.model.TeacherRoster;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeachers();

    Teacher getTeacherById(int id);

    Teacher getTeacherScheduleById(int id);

    TeacherRoster getTeacherRosterByPeriod(int teacherId, int periodId);

    StudentGrade getStudentGradeById(int studentId, int classId);

    StudentGrade updateTeacherClassGrade(StudentGrade studentGrade);



}
