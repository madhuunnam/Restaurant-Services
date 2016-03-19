package com.restaurant.services.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
	
	private String restId;
	private String itemNum;
	private String secName;
	private String itemName;
	private String description;
	private float basePrice;
	private int numChoice;
	
	List<Choice> choices =  new ArrayList<Choice>();
	
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	public String getRestId() {
		return restId;
	}
	public void setRestId(String restId) {
		this.restId = restId;
	}
	public String getItemNum() {
		return itemNum;
	}
	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}
	public String getSecName() {
		return secName;
	}
	public void setSecName(String secName) {
		this.secName = secName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	public int getNumChoice() {
		return numChoice;
	}
	public void setNumChoice(int numChoice) {
		this.numChoice = numChoice;
	}
	@Override
	public String toString() {
		return "Item [restId=" + restId + ", itemNum=" + itemNum + ", secName=" + secName + ", itemName=" + itemName
				+ ", description=" + description + ", basePrice=" + basePrice + ", numChoice=" + numChoice + "]";
	}
	
	

}
