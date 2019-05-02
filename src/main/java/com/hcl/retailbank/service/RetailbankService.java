package com.hcl.retailbank.service;

import org.springframework.stereotype.Service;

import com.hcl.retailbank.pojo.FundTransferRequest;
import com.hcl.retailbank.pojo.FundTransferResponce;

@Service
public interface RetailbankService {

	FundTransferResponce fundTransfer(FundTransferRequest fundTransferrequest);

}
