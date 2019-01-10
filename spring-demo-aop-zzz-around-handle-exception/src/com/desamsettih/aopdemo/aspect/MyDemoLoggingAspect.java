package com.desamsettih.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.desamsettih.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	@Around("execution(* com.desamsettih.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable
	{
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// give user a custom message

			// rethrow exception
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration/1000.0 + " seconds");
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@After("execution(* com.desamsettih.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
	{
		// print  out which method we are advising on
				String method = theJoinPoint.getSignature().toShortString();
				myLogger.info("\n=====>>>> Executing @After (finally) on method: " + method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.desamsettih.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint,Throwable theExc)
	{
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n=====>>>> The exception is : " + theExc);
		
	}
	
	
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	
	@AfterReturning(
			pointcut="execution(* com.desamsettih.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) 
	{
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Executing @AfterRetuning on method: " + method);
		
		
		// print out the results of the method call
		myLogger.info("\n=====>>>> result is: " + result);
	}
	
	
	
	
	
	
	
	
	
	
	// this is where we add all of our related advices for logging
	
	
	
	// let's start with an @Before advice
	
	
	
	
	
	
	//@Before("execution(public void add*())")
	
	// (*) is just one argument and (..) is 0 or more arguments () is no arguments
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account))") if the argument is of type account
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") match any method in DAO package
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account))")
	//@Before("execution(* add*(com.desamsettih.aopdemo.Account, ..))")
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") to match any method *.* and (..) any number of parameters
	//@Before("execution(* com.desamsettih.aopdemo.dao.*.*(..))") Instead of this we can use @Before("forDaoPackage")
	@Before("com.desamsettih.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
	{
		
		myLogger.info("\n======>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		
		
		myLogger.info("Method: "+ methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg:args)
		{
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account)
			{
				// downcast and print Account specific stuff
				Account theAccount = (Account)tempArg;
				
				myLogger.info("account name: "+theAccount.getName());
				myLogger.info("account lvel: "+theAccount.getLevel());
			}
				
			
		}
	}	
}