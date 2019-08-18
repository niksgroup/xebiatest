package com.xebia.retail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.retail.request.PurchaseServiceRequest;
import com.xebia.retail.response.PurchaseServiceResponse;
import com.xebia.retail.service.ItemPurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	ItemPurchaseService ItemPurchaseService;
	
    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public PurchaseServiceResponse greeting(@RequestBody PurchaseServiceRequest Request) {
    	
    	PurchaseServiceResponse Response = new PurchaseServiceResponse();
    	Response = ItemPurchaseService.processOrder(Request, Response);
        return Response;
    }
}
