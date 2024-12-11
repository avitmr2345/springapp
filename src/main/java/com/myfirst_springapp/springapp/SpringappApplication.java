package com.myfirst_springapp.springapp;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.myfirst_springapp.springapp.dao.AppDAO;
import com.myfirst_springapp.springapp.dao.StudentDAO;
import com.myfirst_springapp.springapp.entity.Course;
import com.myfirst_springapp.springapp.entity.Instructor;
import com.myfirst_springapp.springapp.entity.InstructorDetail;
import com.myfirst_springapp.springapp.entity.Review;
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
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// retrieveCourseAndReviews(appDAO);
			// deleteCourseAndReviews(appDAO);
			// createCourseAndStudents(appDAO);
			findCourseAndStudents(appDAO);
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
		int theId = 5;
		System.out.println("Deleting instructor with id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding instructor detail id: " + theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println(tempInstructorDetail);
		System.out.println(tempInstructorDetail.getInstructor());
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 7;
		System.out.println("Deleting instructor detail id: " + theId);

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

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Avi", "T", "avish@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Gaming");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Linux Course");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// this will also save the courses because of CascadeType.PERSIST
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);// it only loads the instructor without courses bcz
																		// they are defaultly lazy loaded for one-many.
																		// So, we change it to EAGER

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated courses are: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		// lazy loading is preferred for faster response of your app
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCourseByInstructorId(theId);

		tempInstructor.setCourses(courses);
		System.out.println("The associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated courses: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Tomar");

		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 12;
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Update course id: " + theId);
		tempCourse.setTitle("MERN Stack Course");

		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 18;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("New Course on Java");

		tempCourse.addReview(new Review("Great course"));
		tempCourse.addReview(new Review("Really great course"));
		tempCourse.addReview(new Review("Amazing course"));
		tempCourse.addReview(new Review("Waste of money course"));

		System.out.println("Saving the course: " + tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 20;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 20;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		Student student1 = new Student("Avi", "Tomar", "avis@gmail.com");
		Student student2 = new Student("A", "T", "avi@gmail.com");

		tempCourse.addStudent(student1);
		tempCourse.addStudent(student2);

		System.out.println("Saving the course: " + tempCourse);
		System.out.println("Associated students: " + tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO){
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());
	}
}
