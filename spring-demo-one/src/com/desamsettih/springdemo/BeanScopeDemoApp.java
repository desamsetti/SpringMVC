package com.desamsettih.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Load the Spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		//Retrieve the bean from Spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		//Check if they are the same bean
		boolean result = (theCoach == alphaCoach);
		
		//Print out the results
		System.out.println("\n Pointing to the same object: "+ result);
		
		System.out.println("\n Memory location for theCoach: "+ theCoach);
		
		System.out.println("\n Memory location for alphaCoach: "+alphaCoach+"\n");
		
		//Close the context
		 context.close();
		

	}

}
