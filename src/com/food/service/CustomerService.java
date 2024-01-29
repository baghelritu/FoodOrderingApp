package com.food.service;

import java.util.List;

import com.food.entity.Customer;

public interface CustomerService {
	
	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(String customerId);
	
	public Customer showCustomerById(String customerId);
	public List<Customer> showAllCustomer();
	public Customer showCustomerByEmail(String custEmail);
	public List<Customer> getCustomerByContact(String contact);
	}


