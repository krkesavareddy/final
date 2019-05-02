package com.hcl.retailbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.retailbank.entity.CustomerFundTransfer;

@Repository
public interface FundTransferRepository extends JpaRepository<CustomerFundTransfer, Long>{

}
