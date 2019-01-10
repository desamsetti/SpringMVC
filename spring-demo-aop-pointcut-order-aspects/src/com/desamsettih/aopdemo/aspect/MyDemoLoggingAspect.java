package com.desamsettih.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	
	// this is where we add all of our related advices for logging
	
	
	
	// let's start with an @Before advice
	
	
	@Pointcut("execution(* com.desamsettih.aopdemo.dao.*.*(..))")
	private void forDaoPackage()
	{
		
	}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.desamsettih.aopdemo.dao.*.get*(..))")
	private void getter()
	{
		
	}
	
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.desamsettih.aopdemo.dao.*.set*(..))")
	private void setter()
	{
		
	}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter()
	{
	}

	
	
	
	//@Before("execution(public void add*())")
	
	// (*) is just one argument and (..) is 0 or more arguments () is no arguments
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account))") if the argument is of type account
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") match any method in DAO package
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account))")
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account, ..))")
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") to match any method *.* and (..) any number of parameters
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") Instead of this we can use @Before("forDaoPackage")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		
		System.out.println("\n=====> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n======>>>> Performing API analytics");
	}
	
	
}










