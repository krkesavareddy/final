package com.hcl.retailbank.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CustomerViewHistory")
public class CustomerViewHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "transactionId")
	private long transactionId;
	@Column(name = "transactionType")
	private String transactionType;
	@Column(name = "transactionDate")
	private Date transactionDate;
	@Column(name = "transactionAmount")
	private double transactionAmount;
	@Column(name = "fromAccountNumber")
	private long fromAccountNumber;
	@Column(name = "toAccountNumber")
	private long toAccountNumber;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
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
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
	
	
	
	
	
}
