package com.hcl.retailbank.service;

import org.springframework.stereotype.Service;

import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.pojo.CustomerRequest;
import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;

@Service
public interface RetailbankService {

	FundTransferResponce fundTransfer(FundTransferRequest fundTransferrequest);

	String addCustomer(CustomerRequest customerRequest);
	
	boolean validateUser(long id);

	void fetchAccountSummary(CustomerCreation customerCreation);

}