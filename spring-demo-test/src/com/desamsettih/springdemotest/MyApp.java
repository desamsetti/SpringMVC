package com.desamsettih.springdemotest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Player thePlayer = context.getBean("myPlayer",Player.class);
		
		System.out.println(thePlayer.getDailyWorkout());
	}

}
