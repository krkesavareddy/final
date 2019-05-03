package com.hcl.retailbank.pojo;

import java.io.Serializable;

public class CustomerRequest implements Serializable{
	private long custId;
	private String name;
	private double balance;
	
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
