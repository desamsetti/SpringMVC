package com.desamsettih.hibernate.practicetutorial.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteWorkerDemo {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();
		 
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a Worker object
			System.out.println("Creating new Worker object...");
			int workerId = 1;
			session.beginTransaction();
			
			
						
			//New Code
			
			Worker newWorker1 = session.get(Worker.class, workerId);
			
			newWorker1.setFirstName("John");
			
			session.delete(newWorker1);
			
			
			
			System.out.println("Done!");
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





