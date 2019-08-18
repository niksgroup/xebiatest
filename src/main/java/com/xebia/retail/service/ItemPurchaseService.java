package com.xebia.retail.service;

import java.util.List;

import com.xebia.retail.bean.CustomerBean;
import com.xebia.retail.bean.ItemBean;
import com.xebia.retail.request.PurchaseServiceRequest;
import com.xebia.retail.response.PurchaseServiceResponse;

public interface ItemPurchaseService {

	public abstract PurchaseServiceResponse processOrder(PurchaseServiceRequest Request, PurchaseServiceResponse Response);
	
	public abstract PurchaseServiceResponse calculateAmount(List<ItemBean> items, CustomerBean customer, PurchaseServiceResponse Response);
}
