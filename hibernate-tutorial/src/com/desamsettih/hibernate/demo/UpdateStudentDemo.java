package com.desamsettih.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.desamsettih.hibernate.demo.entity.Student;

public class UpdateStudentDemo {	
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
			//System.out.println("\nGetting student with the id :"+studentId);
			
			//Student myStudent = session.get(Student.class, studentId);
			
			//System.out.println("Deleting student : "+myStudent);
			
			//session.delete(myStudent);
			
			//Delete id =2
			System.out.println("Deleting student id=2");
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			 
			//Commit transaction
			session.getTransaction().commit();
			
			
			//New Code
			
							

			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
