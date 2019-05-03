package com.hcl.retailbank.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.pojo.CustomerRequest;

import com.hcl.retailbank.pojo.CustomerViewHistory;
import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;
import com.hcl.retailbank.pojo.Response;
import com.hcl.retailbank.repository.CustomerViewHistoryRepository;
import com.hcl.retailbank.service.RetailbankService;

@RestController
@RequestMapping("/retailmapping")

public class RetailController {
	@Autowired
	RetailbankService retailbankService;
	
	@Autowired
	@Qualifier("customerViewHistory")
	private CustomerViewHistoryRepository customerViewHistoryRepository;

	@PostMapping("/fundtransfer")
	public FundTransferResponce fundTransfer(@RequestBody FundTransferRequest fundTransferrequest) {
		return retailbankService.fundTransfer(fundTransferrequest);
	}

	@PostMapping("/addcustomer")
	public String addcustomer(@RequestBody CustomerRequest customerRequest) {
		String s = retailbankService.addCustomer(customerRequest);
		return s;

	}

	@GetMapping("/viewHistory")
	public List<CustomerViewHistory> getCustomerViewHistory() {

		List<CustomerViewHistory> customerViewHistoryData = (List<CustomerViewHistory>) customerViewHistoryRepository
				.findAll();
		return customerViewHistoryData;
	}
	
	@PostMapping("/customerLogin")
	public Response customerLogin(@RequestParam("id") int id) {
		if(retailbankService.validateUser(id)) {
			return new Response("Welcome",Boolean.TRUE);
		}
		return new Response("Please check the user id", Boolean.FALSE);
	}
	
	@GetMapping("/accountSummary")
	public Response getAccountSummary() {
		CustomerCreation customerCreation=new CustomerCreation();
		customerCreation.getCustomerId();
		customerCreation.getCustomerName();
		customerCreation.getBalance();
		retailbankService.fetchAccountSummary(customerCreation);
		return new Response("Custom Account summary",Boolean.TRUE);
	}
}
