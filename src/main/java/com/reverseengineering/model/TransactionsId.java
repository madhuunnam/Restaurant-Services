package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * TransactionsId generated by hbm2java
 */
public class TransactionsId implements java.io.Serializable {

	private int resId;
	private int orderNum;

	public TransactionsId() {
	}

	public TransactionsId(int resId, int orderNum) {
		this.resId = resId;
		this.orderNum = orderNum;
	}

	public int getResId() {
		return this.resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public int getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TransactionsId))
			return false;
		TransactionsId castOther = (TransactionsId) other;

		return (this.getResId() == castOther.getResId()) && (this.getOrderNum() == castOther.getOrderNum());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getResId();
		result = 37 * result + this.getOrderNum();
		return result;
	}

}