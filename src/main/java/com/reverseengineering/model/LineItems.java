package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * LineItems generated by hbm2java
 */
public class LineItems implements java.io.Serializable {

	private LineItemsId id;
	private Integer itemNum;
	private String itemName;
	private String choiceText;
	private Integer quantity;
	private Float price;
	private String note;

	public LineItems() {
	}

	public LineItems(LineItemsId id) {
		this.id = id;
	}

	public LineItems(LineItemsId id, Integer itemNum, String itemName, String choiceText, Integer quantity, Float price,
			String note) {
		this.id = id;
		this.itemNum = itemNum;
		this.itemName = itemName;
		this.choiceText = choiceText;
		this.quantity = quantity;
		this.price = price;
		this.note = note;
	}

	public LineItemsId getId() {
		return this.id;
	}

	public void setId(LineItemsId id) {
		this.id = id;
	}

	public Integer getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getChoiceText() {
		return this.choiceText;
	}

	public void setChoiceText(String choiceText) {
		this.choiceText = choiceText;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
