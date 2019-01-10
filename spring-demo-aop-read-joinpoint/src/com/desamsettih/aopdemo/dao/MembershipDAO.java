package com.desamsettih.aopdemo.dao;
import org.springframework.stereotype.Component;
@Component
public class MembershipDAO {
	
	public boolean addAccount()
	{
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void goToSleep()
	{
		System.out.println("This is a different method");
	}
}