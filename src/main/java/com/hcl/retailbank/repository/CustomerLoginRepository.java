package com.hcl.retailbank.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.retailbank.entity.CustomerCreation;

public interface CustomerLoginRepository extends CrudRepository<CustomerCreation, Integer> {

	void findByCustomerIdAndCustomerNameAndBalance(CustomerCreation customerCreation);
	
}