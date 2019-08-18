package com.xebia.retail.bean;

public class CustomerBean {
	private String customerName;
	private String customerId;
	private String customerType;
	private Integer customerRelationAgeInYrs;

	public CustomerBean(String customerName, String customerId, String customerType, Integer customerRelationAgeInYrs) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerType = customerType;
		this.customerRelationAgeInYrs = customerRelationAgeInYrs;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Integer getCustomerRelationAgeInYrs() {
		return customerRelationAgeInYrs;
	}

	public void setCustomerRelationAgeInYrs(Integer customerRelationAgeInYrs) {
		this.customerRelationAgeInYrs = customerRelationAgeInYrs;
	}

}
