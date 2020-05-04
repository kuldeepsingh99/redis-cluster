package com.portal.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.portal.customer.model.Customer;
import com.portal.customer.repository.CustomerRepository;
import com.portal.customer.vo.CustomerVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@CacheEvict(value= "employeeCache", allEntries= true)
	@Override
	public boolean insertEmployee(CustomerVO customer) {
		
		Customer temp = new Customer();
		temp.setName(customer.getName());
		temp.setAddress(customer.getAddress());
		Customer cust = customerRepository.save(temp);
		if(cust == null) {
			return false;
		} 
		return true;
	}

	@CacheEvict(value= "employeeCache", allEntries= true)	
	@Override
	public boolean updateEmployee(CustomerVO customer) {
		
		Customer temp = new Customer();
		temp.setName(customer.getName());
		temp.setAddress(customer.getAddress());
		temp.setId(Long.parseLong(customer.getId()));
		
		Customer cust = customerRepository.saveAndFlush(temp);
		if(cust == null) {
			return false;
		} 
		return true;
	}

	@Cacheable(value= "employeeCache", key= "#customerId")
	@Override
	public Customer getEmployee(String customerId) {
		Optional<Customer> cust = customerRepository.findById(Long.parseLong(customerId));
		if(cust.isPresent()) {
			return cust.get();
		}
		return null;
	}

	@Cacheable(value= "employeeCache", unless= "#result.size() == 0")
	@Override
	public List<Customer> getAllEmployee() {
		return customerRepository.findAll();
	}

}
