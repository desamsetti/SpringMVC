package com.desamsettih.springdemo.service;

import java.util.List;

import com.desamsettih.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
