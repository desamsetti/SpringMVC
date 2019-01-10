package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Course;
import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			// start a transaction
			session.beginTransaction();
			
			//Create a course
			Course newCourse = new Course("Pacman");
			
			
			//Add some reviews
			newCourse.addReview(new Review("Great course ... loved it"));;
			newCourse.addReview(new Review("Cool course ... loved it"));;
			newCourse.addReview(new Review("Yeah okay course ... loved it"));;
			
			
			System.out.println("Saving the course");
			System.out.println(newCourse);
			System.out.println(newCourse.getReviews());
			
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





