package com.desamsettih.springdemo;

public class BaseballCoach implements Coach {


	//Define a private field for the dependency
	private FortuneService fortuneService;
	
	
	//Define a constructor for Dependency Injection
	public BaseballCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		//Use fortuneService to get fortune
		
		return fortuneService.getFortune();
	}
	
	
	
}
