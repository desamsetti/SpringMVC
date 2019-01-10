package com.desamsettih.springdemo.mvc;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	
	//To read the country names from a class
	private LinkedHashMap<String, String> countryOptions;
	
	public Student()
	{
		//Populate country options : used country code
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("GB", "Great Britain");
	}


	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}


	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}


	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}


	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}


	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}

