package com.desamsettih.springdemo;

public class CricketCoach implements Coach {

	
	//Add new fields for emailAddress and team
	private String emailAddress;
	private String team;
	
	//Generate the getters and setters
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside the setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside the setter method - setTeam");
		this.team = team;
	}
	
	//Create a no argument constructor
	
	
	public CricketCoach()
	{
		System.out.println("CricketCoach: Inside no argument constructor");
	}


	private FortuneService fortuneService;
	//Create the setter method	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
