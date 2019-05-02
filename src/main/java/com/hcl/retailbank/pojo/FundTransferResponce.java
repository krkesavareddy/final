package com.hcl.retailbank.pojo;

import java.io.Serializable;

public class FundTransferResponce implements Serializable {
	private int responceCode;
	private String responceStatus;
	public int getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(int responceCode) {
		this.responceCode = responceCode;
	}
	public String getResponceStatus() {
		return responceStatus;
	}
	public void setResponceStatus(String responceStatus) {
		this.responceStatus = responceStatus;
	}
	 

}
