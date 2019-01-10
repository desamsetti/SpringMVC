package com.desamsettih.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
		
		System.out.println("\n======>>>> Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
		
		
		System.out.println("Method: "+ methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg:args)
		{
			System.out.println(tempArg);
			
			if(tempArg instanceof Account)
			{
				// downcast and print Account specific stuff
				Account theAccount = (Account)tempArg;
				
				System.out.println("account name: "+theAccount.getName());
				System.out.println("account lvel: "+theAccount.getLevel());
			}
				
			
		}
	}	
}