package com.desamsettih.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.desamsettih.hibernate.demo.entity.Student;


public class QueryStudentDemo {

			
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			
			//query students
			//List<Student> theStudents = session.createQuery("from Student").list();
			
			
			//query students whose last name is 'Doe'
			
			//List<Student> newStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			List<Student> newStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Doe");
			displayStudents(newStudents);
			
			
			//display the students
			/*for(Student tempStudent:theStudents)
			{
				System.out.println(tempStudent);
			}*/
		
			//query students : lastName='Doe' OR firstName='Daffy'
			
			//query students where email LIKE '%luv2code.com'
			
			newStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").list();
			System.out.println("\n\nStudents whose email ends with luv2code.com");
			displayStudents(newStudents);
			
			
			
			// save the student object
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> newStudents) {
		for(Student tempStudent:newStudents)
		{
			System.out.println(tempStudent);
		}
	}

}
