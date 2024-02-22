package com.techelevator.dao;

import com.techelevator.model.Subject;

import java.util.List;

public interface SubjectDao {

    List<Subject> getAllSubjects();
    Subject getSubjectById(int id);
    Subject createSubject(Subject subject);
    Subject updateSubject(Subject subject);
    void deleteSubject(Subject subject);
}
