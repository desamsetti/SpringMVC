package com.desamsettih.springdemo;

public class TennisCoach implements Coach{

	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside the setter method : setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	//Creating a no argument constructor
	public TennisCoach()
	{
		System.out.println("Inside the no argument constructor - TennisCoach()");
	}

	private FortuneService fortuneService;
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do wall practice for 2 hours";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	

}
