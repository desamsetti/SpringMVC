package com.desamsettih.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		//Retrieve the bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		
		//Call methods on the bean 
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
	
		
		//Call our new methods to get the literal values
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		
		
		//Close the context
		context.close();

	}

}
