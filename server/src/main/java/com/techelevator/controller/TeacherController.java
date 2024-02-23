package com.techelevator.controller;


import com.techelevator.dao.TeacherDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.StudentGrade;
import com.techelevator.model.Teacher;
import com.techelevator.model.TeacherRoster;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/teachers")
public class TeacherController {

    private final TeacherDao teacherDao;

    public TeacherController(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Teacher> getAllTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        try{
            teachers = teacherDao.getTeachers();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return teachers;
    }

    @RequestMapping(path = "student/{studentId}/class/{classId}", method = RequestMethod.GET)
    public StudentGrade getStudentGradeById(@PathVariable int studentId, @PathVariable int classId){
        StudentGrade studentGrade = new StudentGrade();
        try{
            studentGrade = teacherDao.getStudentGradeById(studentId, classId);
        } catch(DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return studentGrade;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Teacher getTeacherById(@PathVariable int id){
        Teacher teacher = new Teacher();
        try{
            teacher = teacherDao.getTeacherById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return teacher;
    }

    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.GET)
    public Teacher getTeacherSchedule(@PathVariable int id){
        Teacher teacher = new Teacher();
        try {
            teacher = teacherDao.getTeacherScheduleById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return teacher;
    }

    @RequestMapping(path = "/updateGrade/")

    @RequestMapping(path = "/{teacherId}/roster/{periodId}", method = RequestMethod.GET)
    public TeacherRoster getTeacherRoster(@PathVariable int teacherId, @PathVariable int periodId){
        TeacherRoster teacherRoster = new TeacherRoster();
        try{
            teacherRoster = teacherDao.getTeacherRosterByPeriod(teacherId, periodId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return teacherRoster;
    }


}
