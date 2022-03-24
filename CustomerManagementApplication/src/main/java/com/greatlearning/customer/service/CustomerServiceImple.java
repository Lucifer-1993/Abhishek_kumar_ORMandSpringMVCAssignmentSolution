package com.greatlearning.customer.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.customer.dao.CustomerDao;
import com.greatlearning.customer.entity.Customer;

@Service
@Transactional
public class CustomerServiceImple implements CustomerService {

	@Autowired
	CustomerDao studentDao;

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		studentDao.addCustomer(customer);

	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return studentDao.getAllCustomers();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		studentDao.deleteCustomer(customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return studentDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int studentid) {
		// TODO Auto-generated method stub
		return studentDao.getCustomer(studentid);
	}

}
