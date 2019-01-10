package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Student;


public class CreateDemo {

			
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//Create the objects
			/*Instructor newInstructor = new Instructor("Chad","Doe","chaddoe@gmail.com");
			
			InstructorDetail newInstructorDetail = new InstructorDetail("http://youtube.com","Love 2 code");*/
			
			Instructor newInstructor = new Instructor("Hrithik","Roshan","hrithikroshan@gmail.com");
			
			InstructorDetail newInstructorDetail = new InstructorDetail("http://facebook.com","Love");

				
			
			//Associate the objects
			newInstructor.setInstructorDetail(newInstructorDetail);
			
			
			// start a transaction
			session.beginTransaction();
			//Save the instructor
			//Note: This will also save the details object
			//Because of CascadeType.ALL
			session.save(newInstructor);	 
			
			// commit transaction
			System.out.println("Saving instructor :"+newInstructor);
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
