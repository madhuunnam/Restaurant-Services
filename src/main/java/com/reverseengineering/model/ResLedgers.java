package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * ResLedgers generated by hbm2java
 */
public class ResLedgers implements java.io.Serializable {

	private ResLedgersId id;
	private Integer orderNum;
	private String resName;
	private Date ledgerDate;
	private String custName;
	private Float chargeAmt;
	private Float payAmt;
	private String payMethod;
	private String checkNum;
	private String note;
	private Float balance;

	public ResLedgers() {
	}

	public ResLedgers(ResLedgersId id) {
		this.id = id;
	}

	public ResLedgers(ResLedgersId id, Integer orderNum, String resName, Date ledgerDate, String custName,
			Float chargeAmt, Float payAmt, String payMethod, String checkNum, String note, Float balance) {
		this.id = id;
		this.orderNum = orderNum;
		this.resName = resName;
		this.ledgerDate = ledgerDate;
		this.custName = custName;
		this.chargeAmt = chargeAmt;
		this.payAmt = payAmt;
		this.payMethod = payMethod;
		this.checkNum = checkNum;
		this.note = note;
		this.balance = balance;
	}

	public ResLedgersId getId() {
		return this.id;
	}

	public void setId(ResLedgersId id) {
		this.id = id;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public Date getLedgerDate() {
		return this.ledgerDate;
	}

	public void setLedgerDate(Date ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Float getChargeAmt() {
		return this.chargeAmt;
	}

	public void setChargeAmt(Float chargeAmt) {
		this.chargeAmt = chargeAmt;
	}

	public Float getPayAmt() {
		return this.payAmt;
	}

	public void setPayAmt(Float payAmt) {
		this.payAmt = payAmt;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getCheckNum() {
		return this.checkNum;
	}

	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Float getBalance() {
		return this.balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

}
