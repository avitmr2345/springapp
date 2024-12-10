package com.myfirst_springapp.springapp.dao;

import java.util.List;
import com.myfirst_springapp.springapp.entity.Course;
import com.myfirst_springapp.springapp.entity.Instructor;
import com.myfirst_springapp.springapp.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
}
