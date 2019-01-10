package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Course;
import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Review;
import com.desamsettih.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

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
			
			//Get the pacman course from db
			int courseId = 12;
			Course newCourse = session.get(Course.class, courseId);
			
			//Delete the course
			System.out.println("Deleting Course :"+newCourse);
			session.delete(newCourse);						
			
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





