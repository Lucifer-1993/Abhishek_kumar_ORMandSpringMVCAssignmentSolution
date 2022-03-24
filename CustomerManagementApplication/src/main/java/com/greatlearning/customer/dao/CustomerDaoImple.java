package com.greatlearning.customer.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.customer.entity.Customer;
@Repository
@Transactional
public class CustomerDaoImple implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.openSession().saveOrUpdate(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createCriteria(Customer.class)
	                .list();
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		 Customer customer= (Customer) sessionFactory.getCurrentSession().load(
	                Customer.class, customerId);
	        if (null != customer) {
	            this.sessionFactory.getCurrentSession().delete(customer);
	        }

	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(customer);

		return customer;
	}

	@Transactional
	@Override
	public Customer getCustomer(int customerid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		  Customer customer= (Customer) sessionFactory.openSession().load(Customer.class, customerid);
		
		  
		  
		return customer ;
			}

}
