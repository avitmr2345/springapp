package com.myfirst_springapp.springapp;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.myfirst_springapp.springapp.dao.StudentDAO;
import com.myfirst_springapp.springapp.entity.Student;

@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
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
}
