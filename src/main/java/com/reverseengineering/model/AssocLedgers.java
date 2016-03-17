package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * AssocLedgers generated by hbm2java
 */
public class AssocLedgers implements java.io.Serializable {

	private AssocLedgersId id;
	private String assocName;
	private Integer resId;
	private String resName;
	private Date ledgerDate;
	private Float comAmt;
	private Float overrideAmt;
	private Integer overrideId;
	private String overrideName;
	private Float chargeAmt;
	private Float payAmt;
	private String payMethod;
	private String checkNum;
	private String note;
	private Float balance;

	public AssocLedgers() {
	}

	public AssocLedgers(AssocLedgersId id) {
		this.id = id;
	}

	public AssocLedgers(AssocLedgersId id, String assocName, Integer resId, String resName, Date ledgerDate,
			Float comAmt, Float overrideAmt, Integer overrideId, String overrideName, Float chargeAmt, Float payAmt,
			String payMethod, String checkNum, String note, Float balance) {
		this.id = id;
		this.assocName = assocName;
		this.resId = resId;
		this.resName = resName;
		this.ledgerDate = ledgerDate;
		this.comAmt = comAmt;
		this.overrideAmt = overrideAmt;
		this.overrideId = overrideId;
		this.overrideName = overrideName;
		this.chargeAmt = chargeAmt;
		this.payAmt = payAmt;
		this.payMethod = payMethod;
		this.checkNum = checkNum;
		this.note = note;
		this.balance = balance;
	}

	public AssocLedgersId getId() {
		return this.id;
	}

	public void setId(AssocLedgersId id) {
		this.id = id;
	}

	public String getAssocName() {
		return this.assocName;
	}

	public void setAssocName(String assocName) {
		this.assocName = assocName;
	}

	public Integer getResId() {
		return this.resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
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

	public Float getComAmt() {
		return this.comAmt;
	}

	public void setComAmt(Float comAmt) {
		this.comAmt = comAmt;
	}

	public Float getOverrideAmt() {
		return this.overrideAmt;
	}

	public void setOverrideAmt(Float overrideAmt) {
		this.overrideAmt = overrideAmt;
	}

	public Integer getOverrideId() {
		return this.overrideId;
	}

	public void setOverrideId(Integer overrideId) {
		this.overrideId = overrideId;
	}

	public String getOverrideName() {
		return this.overrideName;
	}

	public void setOverrideName(String overrideName) {
		this.overrideName = overrideName;
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