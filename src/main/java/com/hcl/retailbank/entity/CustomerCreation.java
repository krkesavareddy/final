package com.hcl.retailbank.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerCreation implements Serializable {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public long customerId;
public String customerName;
public double balance;
public String phoneNumber;
public Date dob;
public Date creationTimeStamp;
public String accountType;
public long getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public Date getCreationTimeStamp() {
	return creationTimeStamp;
}
public void setCreationTimeStamp(Date creationTimeStamp) {
	this.creationTimeStamp = creationTimeStamp;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}

}