package com.desamsettih.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Load the Spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		
		//Retrieve the bean from Spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		//Close the context
		 context.close();
		

	}

}
