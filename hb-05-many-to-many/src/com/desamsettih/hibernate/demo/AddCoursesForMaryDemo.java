 package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Course;
import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Review;
import com.desamsettih.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			
						
			int studentId = 2;
			
			//Get the student mary from database
			Student newStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoad student :"+newStudent);
			System.out.println("Courses:"+newStudent.getCourses());
			//Create more courses
			Course newCourse1 = new Course("Rubik's Cube");
			Course newCourse2 = new Course("Atari 2600");
			
			
			//Add students to the course
			newCourse1.addStudent(newStudent);
			newCourse2.addStudent(newStudent);
			
			 
			
			
			//Save the courses
			System.out.println("\nSaving the courses ....");
			session.save(newCourse1);
			session.save(newCourse2);
			
	
			
			
			
			
						
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





