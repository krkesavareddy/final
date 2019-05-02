package com.hcl.retailbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.retailbank.entity.CustomerCreation;

public interface CustomerGetRepository extends JpaRepository<CustomerCreation, Long> {
	public CustomerCreation findByCustomerId(Long customerId);

}
