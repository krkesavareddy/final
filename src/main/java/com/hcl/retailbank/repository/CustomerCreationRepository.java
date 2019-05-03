package com.hcl.retailbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.retailbank.entity.CustomerCreation;

@Repository
public interface CustomerCreationRepository extends JpaRepository<CustomerCreation, Long>{

}
