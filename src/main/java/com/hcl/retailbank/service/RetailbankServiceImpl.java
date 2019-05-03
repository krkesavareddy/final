package com.hcl.retailbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.repository.CustomerGetRepository;

@Service
public class RetailbankServiceImpl implements RetailbankService{
	
	@Autowired
	CustomerGetRepository customerGetRepository;


	@Override
	public String customerRegistration(CustomerCreation customer) {
		if(customer.getBalance()>=5000.0) {
		CustomerCreation savedCustomer = customerGetRepository.save(customer);
		return "Account Created Successfully, your A/C no is : " + savedCustomer.getCustomerId();
		}
		else
			return "Minimum balance of 5000.00 is required to open an A/C";
	}

}
