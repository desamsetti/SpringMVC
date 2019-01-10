package com.desamsettih.springdemotest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
	
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Player thePlayer = context.getBean("pingpongPlayer",Player.class);
		
		System.out.println(thePlayer.getDailyWorkout());
		
		System.out.println(thePlayer.getDailyFortune());
		
		context.close();
		
	}
}