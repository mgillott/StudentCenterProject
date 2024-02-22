package com.techelevator.dao;

import com.techelevator.model.Parent;

import java.util.List;

public interface ParentDao {

    List<Parent> getAllParents();
    Parent getParentById(int id);
    Parent createParent(Parent parent);
    Parent updateParent(Parent parent);
    void deleteParent(Parent parent);

}
