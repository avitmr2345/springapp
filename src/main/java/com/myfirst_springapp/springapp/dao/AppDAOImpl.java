package com.myfirst_springapp.springapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myfirst_springapp.springapp.entity.Course;
import com.myfirst_springapp.springapp.entity.Instructor;
import com.myfirst_springapp.springapp.entity.InstructorDetail;
import com.myfirst_springapp.springapp.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        List<Course> courses = tempInstructor.getCourses();

        // break association of all courses for instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        if (tempInstructorDetail != null) {
            // Break the link to avoid cascading delete
            Instructor instructor = tempInstructorDetail.getInstructor();
            if (instructor != null) {
                instructor.setInstructorDetail(null); // Break the bidirectional link
            }
            entityManager.remove(tempInstructorDetail);
        }

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        // better method than the previous commit.
        // Even with fetch type LAZY this code still retrieve Instructor and Courses in
        // a single query. The JOIN FETCH is similar to EAGER loading
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id = :data", Instructor.class);
        // i is alias for Instructor

        query.setParameter("data", theId);

        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);// merge will update an existing entity
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tempCourse = entityManager.find(Course.class, theId);
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager
                .createQuery("select c from Course c " + "JOIN FETCH c.reviews " + "where c.id = :data", Course.class);
        query.setParameter("data", theId);

        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager
                .createQuery("select c from Course c " + "JOIN FETCH c.students " + "where c.id = :data", Course.class);
        query.setParameter("data", theId);

        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {
        TypedQuery<Student> query = entityManager
                .createQuery("select s from Student s " + "JOIN FETCH s.courses " + "where s.id = :data",
                        Student.class);

        query.setParameter("data", theId);

        Student student = query.getSingleResult();
        return student;

    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }
}