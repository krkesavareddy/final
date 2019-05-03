package com.hcl.retailbank.pojo;

import java.io.Serializable;

public class FundTransferResponce implements Serializable {
	private int responceCode;
	private StringBuilder responceMessage;
	public int getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(int responceCode) {
		this.responceCode = responceCode;
	}
	public StringBuilder getResponceMessage() {
		return responceMessage;
	}
	public void setResponceMessage(StringBuilder responceMessage) {
		this.responceMessage = responceMessage;
	}
	
}
