package com.portal.customer.service;

import java.util.List;

import com.portal.customer.model.Customer;
import com.portal.customer.vo.CustomerVO;

public interface CustomerService {

	public boolean insertEmployee(CustomerVO customer);
	
	public boolean updateEmployee(CustomerVO customer);
	
	public Customer getEmployee(String customerId);
	
	public List<Customer> getAllEmployee();
	
}
