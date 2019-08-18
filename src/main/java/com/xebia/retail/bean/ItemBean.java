package com.xebia.retail.bean;

public class ItemBean {
	
	private String itemName;
	private String itemCode;
	private Integer itemPrice;
	private String itemCategory;

	public ItemBean(String itemName, String itemCode, Integer itemPrice, String itemCategory) {
		super();
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

}
