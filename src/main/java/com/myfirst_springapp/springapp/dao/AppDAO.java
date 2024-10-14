package com.myfirst_springapp.springapp.dao;

import com.myfirst_springapp.springapp.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
