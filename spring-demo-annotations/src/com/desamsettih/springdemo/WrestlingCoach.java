package com.desamsettih.springdemo;

import org.springframework.stereotype.Component;

@Component
public class WrestlingCoach implements Coach {

	
	
	private FortuneService fortuneService;
	
	
	public WrestlingCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do daily wrestling practice of 5 hours";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
