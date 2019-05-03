package com.hcl.retailbank.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.retailbank.pojo.CustomerRequest;

import com.hcl.retailbank.pojo.CustomerViewHistory;
>>>>>>> adce04a3e27c8e44c1787996791fe2c6132567e9
import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;
import com.hcl.retailbank.repository.CustomerViewHistoryRepository;
import com.hcl.retailbank.service.RetailbankService;

@RestController
@RequestMapping("/retailmapping")

public class RetailController{
	@Autowired
	RetailbankService retailbankService;

	@PostMapping("/fundtransfer")
	@Autowired
	 @Qualifier("customerViewHistory")
	private CustomerViewHistoryRepository customerViewHistoryRepository;
public FundTransferResponce fundTransfer(@RequestBody FundTransferRequest fundTransferrequest ) {
	return retailbankService.fundTransfer( fundTransferrequest );
	}
	
	@PostMapping("/addcustomer")
	public String addcustomer(@RequestBody CustomerRequest customerRequest ) {
	String s=retailbankService.addCustomer( customerRequest );
		return s;

}

@GetMapping("/viewHistory")
public List<CustomerViewHistory> getCustomerViewHistory() {

	
	List<CustomerViewHistory> customerViewHistoryData=(List<CustomerViewHistory>) customerViewHistoryRepository.findAll();
	return customerViewHistoryData;
}
}
