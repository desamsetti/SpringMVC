package com.desamsettih.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.desamsettih.hibernate.demo.entity.Instructor;
import com.desamsettih.hibernate.demo.entity.InstructorDetail;
import com.desamsettih.hibernate.demo.entity.Student;


public class DeleteInstructorDetailDemo {

			
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
			
						
			
			// start a transaction
			session.beginTransaction();
			
			//Get the instructor detail object
			int theId = 5;
			
			InstructorDetail newInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//Print the instructor detail
			System.out.println("newInstructorDetail :"+newInstructorDetail);
			
			//Print the associated instructor
			System.out.println("The associated instructor :"+newInstructorDetail.getInstructor());
			 			
			System.out.println("Deleting newTempInstructorDetail :"+newInstructorDetail);
			//Now lets delete the instructor detail
			
			//Remove the associated object
			//Break bi directional link
			newInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(newInstructorDetail);
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
