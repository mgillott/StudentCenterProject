package com.techelevator.controller;

import com.techelevator.dao.StudentDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Schedule;
import com.techelevator.model.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The StudentController is a class for handling HTTP Requests related to getting Student information.
 *
 * It depends on an instance of a StudentDAO for retrieving and storing data. This is provided
 * through dependency injection.
 *
 * Note: This class does not handle authentication (registration/login) of Students. That is
 * handled separately in the AuthenticationController.
 */
@RestController
//@Validated
@CrossOrigin
//@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentDao studentDao;


    public StudentController(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            students = studentDao.getStudents();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return students;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable int id){
        Student student = new Student();
        try {
            student = studentDao.getStudentById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return student;
    }

    @RequestMapping(path = "/schedule/{id}", method = RequestMethod.GET)
    public List<Schedule> getStudentScheduleById(@PathVariable int id){
        List<Schedule> studentSchedule;
        try{
            studentSchedule = studentDao.getStudentScheduleById(id);
        } catch (DaoException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return studentSchedule;
    }

}
