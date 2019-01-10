package com.desamsettih.springdemo;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AnnotationDemoApp {
	public static void main(String[] args) {
		//Read Spring config file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		//Get the bean from the Spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		//Coach newCoach = context.getBean("myCoach",Coach.class);
		//Coach newCoach1 = context.getBean("myCoach",Coach.class);
		//Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		/*boolean result = (newCoach==newCoach1);
		
		System.out.println("The two beans are equal : "+result);
		System.out.println("The address of newCoach "+newCoach );
		System.out.println("The address of newCoach1 "+newCoach1);
		
		*/
		//System.out.println(theCoach.getDailyWorkout());
		
		
		//Close the context
		context.close();
	}
}