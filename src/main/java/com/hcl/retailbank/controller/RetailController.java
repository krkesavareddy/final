package com.hcl.retailbank.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailbank.pojo.CustomerViewHistory;
import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;
import com.hcl.retailbank.repository.CustomerViewHistoryRepository;
import com.hcl.retailbank.service.RetailbankService;

@RestController
@RequestMapping("/retailmapping")

public class RetailController{
	@Autowired
	RetailbankService retailbankService;
	@Autowired
	 @Qualifier("customerViewHistory")
	private CustomerViewHistoryRepository customerViewHistoryRepository;
public FundTransferResponce fundTransfer(@RequestBody FundTransferRequest fundTransferrequest ) {
	return retailbankService.fundTransfer( fundTransferrequest );

}

@GetMapping("/viewHistory")
public List<CustomerViewHistory> getCustomerViewHistory() {

	
	List<CustomerViewHistory> customerViewHistoryData=(List<CustomerViewHistory>) customerViewHistoryRepository.findAll();
	return customerViewHistoryData;
}
}
