package com.desamsettih.hibernate.practicetutorial.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateWorkerDemo {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Worker.class).buildSessionFactory();
		 
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a Worker object
			System.out.println("Creating new Worker object...");
			
			Worker newWorker = new Worker("Daffy","Duck","daffyduck@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the Worker object
			System.out.println("Saving the Worker...");
			session.save(newWorker);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





