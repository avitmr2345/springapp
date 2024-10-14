package com.myfirst_springapp.springapp;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.myfirst_springapp.springapp.dao.AppDAO;
import com.myfirst_springapp.springapp.dao.StudentDAO;
import com.myfirst_springapp.springapp.entity.Instructor;
import com.myfirst_springapp.springapp.entity.InstructorDetail;
import com.myfirst_springapp.springapp.entity.Student;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Avish", "Tomar", "avish@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Gaming");

		tempInstructor.setInstructorDetail(tempInstructorDetail); // associate the objects

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor); // This will also save the details object because of CascadeType.ALL
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor with id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Avish", "Tomar", "avish@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Student saved with generated id: " + tempStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		int id = 1;
		System.out.println("Retrieving student with id 1");
		Student myStudent = studentDAO.findById(id);
		System.out.println("Found the student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Tomar");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		myStudent.setFirstName("Avi");
		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted");
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numOfRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numOfRowsDeleted);
	}
}
