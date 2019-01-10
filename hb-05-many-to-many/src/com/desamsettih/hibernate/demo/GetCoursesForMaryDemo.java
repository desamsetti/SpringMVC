package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Course;
import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Review;
import com.desamsettih.hibernate.demo.entity.Student;

public class GetCoursesForMaryDemo {

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
			
			
			
			//Delete student
			
			System.out.println("\nDeleting student:"+newStudent);
			session.delete(newStudent);
			
	
			
			
			
			
						
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





