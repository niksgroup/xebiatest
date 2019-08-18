package com.xebia.retail.response;

public class PurchaseServiceResponse {
	private String status;
	private String message;
	
	public PurchaseServiceResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public PurchaseServiceResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
