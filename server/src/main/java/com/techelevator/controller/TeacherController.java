package com.techelevator.controller;


import com.techelevator.dao.TeacherDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Teacher;
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

}
