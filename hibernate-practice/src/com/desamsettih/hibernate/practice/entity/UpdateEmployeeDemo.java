package com.desamsettih.hibernate.practice.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a employee object
			
			int employeeId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			Employee newEmployee = session.get(Employee.class, employeeId);
			// save the employee object
			System.out.println("Upating the employee with id : "+ employeeId);
			System.out.println(newEmployee);
			
			newEmployee.setFirstName("Dave");
			
			session.save(newEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the employee's id: primary key
			System.out.println("Saved employee. Generated id: " + newEmployee.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + newEmployee.getId());
			
			Employee myEmployee = session.get(Employee.class, newEmployee.getId());
			
			System.out.println("Get complete: " + myEmployee);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





