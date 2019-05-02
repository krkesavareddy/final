package com.hcl.retailbank.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.entity.CustomerFundTransfer;
import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;
import com.hcl.retailbank.repository.CustomerGetRepository;
import com.hcl.retailbank.repository.FundTransferRepository;

@Service
public class RetailbankServiceImpl implements RetailbankService{
	@Autowired
	FundTransferRepository fundTransferRepository;
	@Autowired
	CustomerGetRepository customerGetRepository;

	@Override
	public FundTransferResponce fundTransfer(FundTransferRequest fundTransferrequest) {
		
		FundTransferResponce fundTransferResponce = new FundTransferResponce();
		try {
			CustomerFundTransfer customerFundTransfer = new CustomerFundTransfer();
			customerFundTransfer.setFromAccountNumber(fundTransferrequest.getFromAccountNumber());
			
		 CustomerCreation source= customerGetRepository.findByCustomerId(fundTransferrequest.getFromAccountNumber());
		 double current=source.getBalance();
			double update=current-fundTransferrequest.getTransactionAmount();
			source.setBalance(update);
			customerGetRepository.save(source);
		 customerFundTransfer.setToAccountNumber(fundTransferrequest.getToAccountNumber());
		 
			CustomerCreation destination= customerGetRepository.findByCustomerId(fundTransferrequest.getToAccountNumber());
			
			double current1=destination.getBalance();
			double update1=current1+fundTransferrequest.getTransactionAmount();
			destination.setBalance(update1);
			customerGetRepository.save(destination);
			customerFundTransfer.setTransactionAmmount(fundTransferrequest.getTransactionAmount());
		
			customerFundTransfer.setTransactionRemarks(fundTransferrequest.getTransactionremarks());
			customerFundTransfer.setTransactionType(fundTransferrequest.getTransactionType());
			customerFundTransfer.setTransactiondate(new Date());
			
			customerFundTransfer.setTransactionStatus("sucess");
			fundTransferRepository.save(customerFundTransfer);
			
			fundTransferResponce.setResponceCode(200);
			fundTransferResponce.setResponceStatus("sucess");
			return fundTransferResponce;
		}catch(Exception e) {
			fundTransferResponce.setResponceCode(400);
			fundTransferResponce.setResponceStatus("fail");
			return fundTransferResponce;
			
		}
		
		
		
		
	}

}
