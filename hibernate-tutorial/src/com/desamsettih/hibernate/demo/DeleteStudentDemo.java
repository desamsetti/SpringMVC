package com.desamsettih.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.desamsettih.hibernate.demo.entity.Student;

public class DeleteStudentDemo {	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;

			session = factory.getCurrentSession();
			session.beginTransaction();		
			
			
			//Retrieve the student based on the primary key
			System.out.println("\nGetting student with the id :"+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			myStudent.setLastName("Doo");
			//Commit transaction
			session.getTransaction().commit();
			
			
			//New Code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Update email for all students
			System.out.println("Update email for all students");
			
			session.createQuery("update Student set email = 'hello@gmail.com'")
				.executeUpdate();
			
			
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
