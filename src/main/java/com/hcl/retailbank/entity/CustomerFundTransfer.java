package com.hcl.retailbank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerFundTransfer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long transactionId;
	private String transactionType;
	private String transactionRemarks;
	private Date transactiondate;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
	public double getTransactionAmmount() {
		return transactionAmmount;
	}
	public void setTransactionAmmount(double transactionAmmount) {
		this.transactionAmmount = transactionAmmount;
	}
	public long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public long getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	private double transactionAmmount;
	private long fromAccountNumber;
	private long toAccountNumber;
	private String transactionStatus;
	//private LocalDate time;
	
	
}
