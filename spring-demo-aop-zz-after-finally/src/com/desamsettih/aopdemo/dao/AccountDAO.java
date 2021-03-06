package com.desamsettih.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.desamsettih.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	// add a new method: findAccounts()
	public List<Account> findAccounts(boolean tripWire)
	{
		
		// for academic purpose ... simulate an exception
		if(tripWire)
		{
			throw new RuntimeException("Exception!? Thrown???????");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		// create sample accounts
		Account temp1 = new Account("John","silver");
		Account temp2 = new Account("Hrithik","Gold");
		Account temp3 = new Account("Luca","Gold");
		
		
				
		
		
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	
	public void addAccount(Account theAccount, boolean vipFlag)
	{
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": in GetServiceCode()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}


	public boolean doWork()
	{
		System.out.println(getClass()+":doWork()");
		return false;
	}
}