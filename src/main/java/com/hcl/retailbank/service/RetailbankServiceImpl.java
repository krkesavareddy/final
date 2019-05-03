package com.hcl.retailbank.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hcl.retailbank.entity.CustomerCreation;
import com.hcl.retailbank.entity.CustomerFundTransfer;
import com.hcl.retailbank.pojo.CustomerRequest;
import com.hcl.retailbank.pojo.CustomerViewHistory;
import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;
import com.hcl.retailbank.repository.CustomerCreationRepository;
import com.hcl.retailbank.repository.CustomerGetRepository;
import com.hcl.retailbank.repository.CustomerViewHistoryRepository;
import com.hcl.retailbank.repository.FundTransferRepository;

@Service
public class RetailbankServiceImpl implements RetailbankService{
	@Autowired
	FundTransferRepository fundTransferRepository;
	@Autowired
	CustomerGetRepository customerGetRepository;
	@Autowired
	CustomerCreationRepository customerCreationRepository;

	 @Autowired
	 @Qualifier("customerViewHistoryRepositories")
	private CustomerViewHistoryRepository customerViewHistoryRepository;
	@Override
	public FundTransferResponce fundTransfer(FundTransferRequest fundTransferrequest) {
		
		FundTransferResponce fundTransferResponce = new FundTransferResponce();
		try {
			CustomerFundTransfer customerFundTransfer = new CustomerFundTransfer();
			customerFundTransfer.setFromAccountNumber(fundTransferrequest.getFromAccountNumber());
			customerFundTransfer.setToAccountNumber(fundTransferrequest.getToAccountNumber());
		 CustomerCreation source= customerGetRepository.findByCustomerId(fundTransferrequest.getFromAccountNumber());
		 double current=source.getBalance();
		 double update=current-fundTransferrequest.getTransactionAmount();
		 if(current>5000 && update>5000){
			source.setBalance(update);
			customerGetRepository.save(source);
		 }else {
			 fundTransferResponce.setResponceCode(400);
			StringBuilder stringBuilder =new StringBuilder();
			 stringBuilder.append("unable to process because insufficiends balance you must maintain minimum balance");
			fundTransferResponce.setResponceMessage(stringBuilder);
			return fundTransferResponce;
		 }
			
		 
		 
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

			StringBuilder stringBuilder =new StringBuilder();
             stringBuilder.append(fundTransferrequest.getTransactionAmount());
			 stringBuilder.append(" rupess can transfer sucessfully to ");
			 stringBuilder.append(fundTransferrequest.getToAccountNumber());
			fundTransferResponce.setResponceMessage(stringBuilder);

			fundTransferResponce.setResponceStatus("sucess");
			
			CustomerViewHistory customerViewHistory=new CustomerViewHistory();
			customerViewHistory.setFromAccountNumber(customerFundTransfer.getFromAccountNumber());
			customerViewHistory.setToAccountNumber(customerFundTransfer.getToAccountNumber());
			customerViewHistory.setTransactionAmount(customerFundTransfer.getTransactionAmmount());
			customerViewHistory.setTransactionDate(customerFundTransfer.getTransactiondate());
			customerViewHistory.setTransactionId(customerFundTransfer.getTransactionId());
			customerViewHistory.setTransactionType(customerFundTransfer.getTransactionType());
			customerViewHistoryRepository.save(customerViewHistory);
			return fundTransferResponce;
			
		}catch(Exception e) {
			fundTransferResponce.setResponceCode(400);
			fundTransferResponce.setResponceMessage(new StringBuilder("some internal problem please try after sometimes"));
			return fundTransferResponce;
			
		}
		
	}

	@Override
	public String addCustomer(CustomerRequest customerRequest) {
		CustomerCreation customerCreation =new CustomerCreation();
		customerCreation.setCustomerName(customerRequest.getName());
		customerCreation.setBalance(customerRequest.getBalance());
		customerCreationRepository.save(customerCreation);
		return "sucessfully added";
	}

}
