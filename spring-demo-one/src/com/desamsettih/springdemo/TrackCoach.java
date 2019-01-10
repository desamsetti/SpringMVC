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
	//Add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach : Inside method doMyStartupStuff");
	}
	
	//Add a destroy method
	public void doMyCleanupStuff()
	{
		System.out.println("TrackCoach : Inside method doMyCleanupStuff");
	}
}
