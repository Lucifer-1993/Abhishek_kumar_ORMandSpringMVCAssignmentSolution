package com.greatlearning.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.customer.entity.Customer;
import com.greatlearning.customer.service.CustomerService;

@Controller
@EnableTransactionManagement
public class CustomerController {
	 @Autowired
	    private CustomerService customerService;
	 
	    @RequestMapping(value = "/")
	    public ModelAndView listCustomers(ModelAndView model) throws IOException{
	        List<Customer> listCustomer = customerService.getAllCustomers() ;
	        model.addObject("Customers", listCustomer);
	        model.setViewName("list-customers");
	        return model;
	    }
	 
	    @RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	    public ModelAndView newContact(ModelAndView model) {
	        Customer customer = new Customer();
	        model.addObject("customer", customer);
	        model.setViewName("customers-form");
	        return model;
	    }
	 
	    @RequestMapping(value = "/saveCustomers", method = RequestMethod.POST)
	    public ModelAndView saveEmployee(@ModelAttribute Customer customer) {
	        if (customer.getId() == 0) { 
	            customerService.addCustomer(customer);
	        } else {
	        	customer.setId(customer.getId());
	            customerService.updateCustomer(customer);
	        }
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	    public ModelAndView deleteEmployee(HttpServletRequest request) {
	        int studentId = Integer.parseInt(request.getParameter("id"));
	        customerService.deleteCustomer(studentId);
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	    public ModelAndView editContact(HttpServletRequest request) {
	        int customerId = Integer.parseInt(request.getParameter("id"));
	        Customer  customer= customerService.getCustomer(customerId);
	        ModelAndView model = new ModelAndView("customers-form");
	        model.addObject("customer", customer);
	 
	        return model;
	    }
}
