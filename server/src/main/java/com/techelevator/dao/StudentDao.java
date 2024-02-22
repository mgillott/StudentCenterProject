package com.techelevator.dao;

import com.techelevator.model.Schedule;
import com.techelevator.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> getStudents();
    Student getStudentById(int id);
    List<Schedule> getStudentScheduleById(int id);

}
