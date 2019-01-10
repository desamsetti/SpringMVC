package com.desamsettih.springdemotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PingpongPlayer implements Player 
{
	@Autowired
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() 
	{
		return "Practice Ping Pong shots";
	}
	
	
@Autowired
public void setFortuneService(FortuneService theFortuneService)
{
	System.out.println("PingPongCoach : Inside the method setFortuneService");
	fortuneService = theFortuneService;
}
	
	
	/*@Autowired
	public PingpongPlayer(FortuneService theFortuneService)
	{
		System.out.println("Inside the constructor Ping Pong Coach");
		fortuneService = theFortuneService;
	}*/
	
	@Autowired
	public PingpongPlayer()
	{
		System.out.println("Inside the default constructor Ping Pong Coach");
		
	}
	
	
	
	
	
	@Override 
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}
}