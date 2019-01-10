package com.desamsettih.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	
	
	public TrackCoach(FortuneService fortuneService) {
		
		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It : " + fortuneService.getFortune();
	}

}
