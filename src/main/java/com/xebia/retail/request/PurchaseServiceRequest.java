package com.xebia.retail.request;

import java.util.ArrayList;
import java.util.List;

import com.xebia.retail.bean.ItemBean;
import com.xebia.retail.bean.CustomerBean;

public class PurchaseServiceRequest {
	private CustomerBean customer;
	private List<ItemBean> itemList =  new ArrayList<ItemBean>();
	
	public PurchaseServiceRequest(CustomerBean customer, List<ItemBean> itemList) {
		super();
		this.customer = customer;
		this.itemList = itemList;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setUser(CustomerBean customer) {
		this.customer = customer;
	}

	public List<ItemBean> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemBean> itemList) {
		this.itemList = itemList;
	}
	
	
}
