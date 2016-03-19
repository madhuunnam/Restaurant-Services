package com.restaurant.services.model;

import java.util.ArrayList;
import java.util.List;

public class Section {

	private String restId;
	private String secName;
	private int numItem;
	
	List<Item> items =  new ArrayList<Item>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public int getNumItem() {
		return numItem;
	}

	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}

	@Override
	public String toString() {
		return "Section [restId=" + restId + ", secName=" + secName + ", numitem=" + numItem + "]";
	}
}
