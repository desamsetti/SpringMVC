package com.desamsettih.springdemotest;

public class CricketPlayer implements Player {
	public CricketPlayer()
	{
		System.out.println("Inside the class CricketPlayer no argument constructor");
	}
	
	FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do 2 hours of batting practice in cricket";
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside the setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}
}