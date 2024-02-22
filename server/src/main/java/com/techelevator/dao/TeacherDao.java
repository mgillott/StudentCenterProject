package com.techelevator.dao;

import com.techelevator.model.Teacher;

import java.util.List;

public interface TeacherDao {

    List<Teacher> getTeachers();

    Teacher getTeacherScheduleById(int id);

}
