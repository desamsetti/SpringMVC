package com.desamsettih.hibernate.practice.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {

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
			System.out.println("Deleting the employee with id : "+ employeeId);
			System.out.println(newEmployee);
			
			session.delete(newEmployee);
			
			
			
			// commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}





