package com.xebia.retail.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xebia.retail.bean.CustomerBean;
import com.xebia.retail.bean.ItemBean;
import com.xebia.retail.exception.ServiceException;
import com.xebia.retail.request.PurchaseServiceRequest;
import com.xebia.retail.response.PurchaseServiceResponse;
import com.xebia.retail.service.ItemPurchaseService;
import com.xebia.retail.util.Constants;

@Service("ItemPurchaseService")
public class ItemPurchaseServiceImpl implements ItemPurchaseService {

	@Override
	public PurchaseServiceResponse processOrder(PurchaseServiceRequest Request, PurchaseServiceResponse Response) {
		List<ItemBean> items = null;
		CustomerBean customer = null;
		try {
			if (Request != null) {
				if (Request.getCustomer() != null) {
					customer = Request.getCustomer();
				} else {
					throw new ServiceException("Customer details missing");
				}
				if (Request.getItemList() != null) {
					items = Request.getItemList();
				} else {
					throw new ServiceException("Item details missing");
				}

				Response = this.calculateAmount(items, customer, Response);

			} else {
				throw new ServiceException("No Input Received");
			}

		} catch (ServiceException e) {
			Response.setMessage(e.getMessage());
			Response.setStatus("ERROR");
		} catch (Exception e) {
			Response.setMessage("Service Error. Please check your input and re-try");
			Response.setStatus("ERROR");
		}

		return Response;
	}

	@Override
	public PurchaseServiceResponse calculateAmount(List<ItemBean> items, CustomerBean customer,
			PurchaseServiceResponse Response) {
		double discountPer = 0;
		double finalDisAmount = 0;
		double totalAmount = 0;
		double itemPrice = 0;
		String itemCategory = null;
		double totalBillOff= 0;
		double customerRelationAgeInYrs= 0;
		try {
			String customerType = customer.getCustomerType();
			customerRelationAgeInYrs = customer.getCustomerRelationAgeInYrs();
			if (customerType == null)
				throw new ServiceException("Customer type missing");
			switch (customerType) {
			
			case "EMP":
				discountPer = Constants.USER_DIS_EMP;
				break;
			case "CUST":
				if(customerRelationAgeInYrs > 1)
					discountPer = Constants.USER_DIS_CUST;
				break;
			case "AFFL":
				discountPer = Constants.USER_DIS_AFF;
				break;

			}

			for (ItemBean itemObj : items) {
				itemPrice = itemObj.getItemPrice();
				totalAmount =  totalAmount + itemPrice;
				itemCategory = itemObj.getItemCategory();
				if(itemCategory.equalsIgnoreCase("groceries"))
					continue;
				
				if (itemPrice != 0) {
					finalDisAmount = finalDisAmount + (itemPrice * discountPer / 100);
				}
			}
			
			totalAmount = totalAmount-finalDisAmount;
			
			if(totalAmount > 99) {
				totalAmount = totalAmount - totalAmount%100;
				totalBillOff = totalAmount/100 * 5;
				totalAmount = totalAmount - totalBillOff ;
				finalDisAmount = finalDisAmount + totalBillOff;
			}
				
			
			Response.setMessage("Please pay : $" + totalAmount + ". You got a discount of $"+finalDisAmount);
			Response.setStatus("SUCCESS");
			// throw new ServiceException("No Input Received");
		} catch (ServiceException e) {
			Response.setMessage(e.getMessage());
			Response.setStatus("ERROR");
		} catch (Exception e) {
			Response.setMessage("Service Error. Please check your input and re-try");
			Response.setStatus("ERROR");
		}

		return Response;
	}

}
