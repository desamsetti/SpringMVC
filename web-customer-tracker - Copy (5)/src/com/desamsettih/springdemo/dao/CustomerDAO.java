package com.desamsettih.springdemo.dao;

import java.util.List;

import com.desamsettih.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
