package com.hcl.retailbank.pojo;

import java.io.Serializable;

public class FundTransferRequest implements Serializable {
	private String transactionType;
	private String transactionremarks;
	private double transactionAmount;
	private long fromAccountNumber;
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionremarks() {
		return transactionremarks;
	}
	public void setTransactionremarks(String transactionremarks) {
		this.transactionremarks = transactionremarks;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
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
	private long toAccountNumber;

}
