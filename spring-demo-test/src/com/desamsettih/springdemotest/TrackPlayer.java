package com.desamsettih.springdemotest;


public class TrackPlayer implements Player{

	FortuneService fortuneService;
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do 30 minutes running daily";
	}

	public TrackPlayer()
	{
		System.out.println("Inside the no argument constructor TrackPlayer");
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}
	
	public TrackPlayer(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}
	

}
