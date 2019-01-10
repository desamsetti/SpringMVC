package com.desamsettih.hibernate.practicetutorial.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadWorkerDemo {

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
			
			//New Code
			
			Session session1 = factory.getCurrentSession();
			
			session1.beginTransaction();
			
			System.out.println("Reading data : "+newWorker.getId());
			
			Worker newWorker1 = session1.get(Worker.class, newWorker.getId());
			
			System.out.println(newWorker1);
			
			
			
			System.out.println("Done!");
			
			session1.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





