package com.hcl.retailbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;
import com.hcl.retailbank.service.RetailbankService;

@RestController
@RequestMapping("/retailmapping")

public class RetailController{
	@Autowired
	RetailbankService retailbankService;
public FundTransferResponce fundTransfer(@RequestBody FundTransferRequest fundTransferrequest ) {
	return retailbankService.fundTransfer( fundTransferrequest );

}
}
