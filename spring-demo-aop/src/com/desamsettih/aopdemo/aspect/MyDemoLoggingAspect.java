package com.desamsettih.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	// this is where we add all of our related advices for logging
	
	
	
	// let's start with an @Before advice
	
	//@Before("execution(public void add*())")
	
	// (*) is just one argument and (..) is 0 or more arguments () is no arguments
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account))") if the argument is of type account
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") match any method in DAO package
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account))")
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account, ..))")
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") to match any method *.* and (..) any number of parameters
	@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice()
	{
		
		System.out.println("\n=====> Executing @Before advice on method");
	}
	
	
}










