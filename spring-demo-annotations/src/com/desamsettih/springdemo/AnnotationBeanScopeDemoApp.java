package com.desamsettih.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Load Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		//Retrive bean from the Spring container
		
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		//Check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\n Pointing to the same object : "+result);
		
		System.out.println("\n Memory location for theCoach : "+theCoach);
		
		System.out.println("\n Memory location for alphaCoach : "+alphaCoach);
		
		
		//CLose the context
		context.close();
		
		
	}

}
