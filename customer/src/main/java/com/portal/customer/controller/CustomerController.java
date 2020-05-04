package com.portal.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.customer.model.Customer;
import com.portal.customer.service.CustomerService;
import com.portal.customer.vo.CustomerVO;

@RestController
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(path = "/customer/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Boolean createCustomer(@RequestBody CustomerVO customerVO) {

		LOGGER.info("---------------------- Inside createCustomer ------------------------");
		return customerService.insertEmployee(customerVO);
		
	}
	
	@RequestMapping(path = "/customer/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Boolean updateCustomer(@RequestBody CustomerVO customerVO) {

		LOGGER.info("---------------------- Inside updateCustomer ------------------------");
		return customerService.updateEmployee(customerVO);
		
	}
	
	@RequestMapping(path = "/customer/getall", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public List<Customer> getAllCustomer() {
		LOGGER.info("---------------------- Inside getAllCustomer ------------------------");
		return customerService.getAllEmployee();
	}
	
	@RequestMapping(path = "/customer/getcustomerbyid", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public Customer getCustomer(@RequestParam("id") String id) {
		LOGGER.info("---------------------- Inside getCustomer ------------------------");
		return customerService.getEmployee(id);
	}
}
