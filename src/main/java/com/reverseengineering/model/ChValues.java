package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * ChValues generated by hbm2java
 */
public class ChValues implements java.io.Serializable {

	private ChValuesId id;
	private Float valuePrice;
	private Boolean extra;

	public ChValues() {
	}

	public ChValues(ChValuesId id) {
		this.id = id;
	}

	public ChValues(ChValuesId id, Float valuePrice, Boolean extra) {
		this.id = id;
		this.valuePrice = valuePrice;
		this.extra = extra;
	}

	public ChValuesId getId() {
		return this.id;
	}

	public void setId(ChValuesId id) {
		this.id = id;
	}

	public Float getValuePrice() {
		return this.valuePrice;
	}

	public void setValuePrice(Float valuePrice) {
		this.valuePrice = valuePrice;
	}

	public Boolean getExtra() {
		return this.extra;
	}

	public void setExtra(Boolean extra) {
		this.extra = extra;
	}

}
