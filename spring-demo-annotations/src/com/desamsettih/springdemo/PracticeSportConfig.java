package com.desamsettih.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.desamsettih.springdemo")
public class PracticeSportConfig {
	
	
	
	//Define bean for the other Fortune service
	@Bean
	public FortuneService happiestFortuneService()
	{
		return new HappiestFortuneService();
	}
	


//Define bean for the swim coach and inject dependencies for the swim  coach
@Bean
public Coach wrestlingCoach()
{
	return new WrestlingCoach(happiestFortuneService());
}	
}