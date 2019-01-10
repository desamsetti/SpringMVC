package com.desamsettih.springdemo;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//@Component("thatSillyCoach")
@Component
//The @Component takes the default bean id which is the classname, here the classname is TennisCoach
// and the default bean id is tennisCoach
public class TennisCoach implements Coach {
	
	
	//Field injection, even though the variable is private,Spring will still set this value.
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;
	
	
	//Autowiring using Constructor injection
	@Autowired
	public TennisCoach(FortuneService theFortuneService)
	{
		System.out.println("TennisCoach : Inside the constructor");
		fortuneService = theFortuneService;
	}
	
	
	//Autowiring using Setter injection
	public TennisCoach()
	{
		System.out.println("TennisCoach : Inside the default constructor");
	}
	
	
	
	
	//Define my init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println("TennisCoach : Inside doMyStartupStuff()");
	}

	
	
	//Define my destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println("TennisCoach : Inside doMyCleanupStuff()");
	}
	
	
	
	//Define a setter method
	//public void	setFortuneService(FortuneService theFortuneService)
	//Using method autowired injection
	@Autowired
	public void	setFortuneService(FortuneService theFortuneService)
	{
		System.out.println("TennisCoach : Inside setFortuneService() method");
		fortuneService = theFortuneService;
	}
	
	/*@Autowired
	public void	doSomeCrazyStuff(FortuneService theFortuneService)
	{
		System.out.println("TennisCoach : Inside doSomeCrazyStuff() method");
		fortuneService = theFortuneService;
	}*/
	
	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}