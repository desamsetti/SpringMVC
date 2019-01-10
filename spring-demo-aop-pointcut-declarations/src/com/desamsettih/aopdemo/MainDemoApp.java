package com.desamsettih.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.desamsettih.aopdemo.dao.AccountDAO;
import com.desamsettih.aopdemo.dao.MembershipDAO;
import com.desamsettih.aopdemo.dao.SwimmingDAO;

public class MainDemoApp{

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		
		// get swimming bean from spring container
		SwimmingDAO theSwimmingDAO = context.getBean("swimmingDAO",SwimmingDAO.class);
		
		Account myAccount = new Account();
		
		// call the business method
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		String hello = "HeyHEy";
		// call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		System.out.println("\n\n\n\n")  ;
		// call the swimming method
		theSwimmingDAO.addAccountSwimmingDAO();
		
		// close the context
		context.close();
	}

}
