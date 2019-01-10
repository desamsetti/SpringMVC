package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Course;
import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Review;
import com.desamsettih.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {				
			// start a transaction
			session.beginTransaction();
			
			//Create a course
			Course newCourse = new Course("Pacman1");
			
			
			//Add some reviews
						
			System.out.println("Saving the course");
			System.out.println(newCourse);
			System.out.println("Saved the course: "+newCourse);
			
			//Create the students
			Student newStudent1 = new Student("John","Doe","john@luv2code.com");
			Student newStudent2 = new Student("Mary","Public","mary@luv2code.com");
			
			//Add students to the course
			newCourse.addStudent(newStudent1);
			newCourse.addStudent(newStudent2);
			
			//Save the students
			System.out.println("\nSaving students ... ");
			session.save(newStudent1);
			session.save(newStudent2);
			System.out.println("Saved students : "+newCourse.getStudents());
			
			
			session.save(newCourse);
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





