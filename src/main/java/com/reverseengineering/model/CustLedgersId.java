package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * CustLedgersId generated by hbm2java
 */
public class CustLedgersId implements java.io.Serializable {

	private int custId;
	private int ledgerNum;

	public CustLedgersId() {
	}

	public CustLedgersId(int custId, int ledgerNum) {
		this.custId = custId;
		this.ledgerNum = ledgerNum;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getLedgerNum() {
		return this.ledgerNum;
	}

	public void setLedgerNum(int ledgerNum) {
		this.ledgerNum = ledgerNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CustLedgersId))
			return false;
		CustLedgersId castOther = (CustLedgersId) other;

		return (this.getCustId() == castOther.getCustId()) && (this.getLedgerNum() == castOther.getLedgerNum());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCustId();
		result = 37 * result + this.getLedgerNum();
		return result;
	}

}
