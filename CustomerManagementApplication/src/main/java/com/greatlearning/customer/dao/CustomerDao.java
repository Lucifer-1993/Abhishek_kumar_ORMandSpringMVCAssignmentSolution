package com.greatlearning.customer.dao;

import java.util.List;

import com.greatlearning.customer.entity.Customer;

public interface CustomerDao {
	 public void addCustomer(Customer customer);
	 
	    public List<Customer> getAllCustomers();
	 
	    public void deleteCustomer(Integer customerId);
	 
	    public Customer updateCustomer(Customer customer);
	 
	    public Customer getCustomer(int customerid);
}
