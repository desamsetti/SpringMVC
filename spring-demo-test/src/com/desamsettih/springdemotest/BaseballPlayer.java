package com.desamsettih.springdemotest;

public class BaseballPlayer implements Player{

	FortuneService fortuneService;
	public BaseballPlayer()
	{
		System.out.println("Inside the no argument constructor BaseballPlayer");
	}
	
	public String getDailyWorkout()
	{
		return "Do 30 minutes batting practice daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stubt
		return fortuneService.getDailyFortune();
	}
	
	public BaseballPlayer(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
}
