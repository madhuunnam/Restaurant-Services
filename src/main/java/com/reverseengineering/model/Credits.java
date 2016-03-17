package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

/**
 * Credits generated by hbm2java
 */
public class Credits implements java.io.Serializable {

	private int custId;
	private String addr2;
	private String addr3;
	private String addr4;
	private Integer numCust;
	private Integer numRes;
	private Integer numRev;
	private Integer numOrders;
	private Integer totCredits;
	private Integer creditBal;

	public Credits() {
	}

	public Credits(int custId) {
		this.custId = custId;
	}

	public Credits(int custId, String addr2, String addr3, String addr4, Integer numCust, Integer numRes,
			Integer numRev, Integer numOrders, Integer totCredits, Integer creditBal) {
		this.custId = custId;
		this.addr2 = addr2;
		this.addr3 = addr3;
		this.addr4 = addr4;
		this.numCust = numCust;
		this.numRes = numRes;
		this.numRev = numRev;
		this.numOrders = numOrders;
		this.totCredits = totCredits;
		this.creditBal = creditBal;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAddr3() {
		return this.addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public String getAddr4() {
		return this.addr4;
	}

	public void setAddr4(String addr4) {
		this.addr4 = addr4;
	}

	public Integer getNumCust() {
		return this.numCust;
	}

	public void setNumCust(Integer numCust) {
		this.numCust = numCust;
	}

	public Integer getNumRes() {
		return this.numRes;
	}

	public void setNumRes(Integer numRes) {
		this.numRes = numRes;
	}

	public Integer getNumRev() {
		return this.numRev;
	}

	public void setNumRev(Integer numRev) {
		this.numRev = numRev;
	}

	public Integer getNumOrders() {
		return this.numOrders;
	}

	public void setNumOrders(Integer numOrders) {
		this.numOrders = numOrders;
	}

	public Integer getTotCredits() {
		return this.totCredits;
	}

	public void setTotCredits(Integer totCredits) {
		this.totCredits = totCredits;
	}

	public Integer getCreditBal() {
		return this.creditBal;
	}

	public void setCreditBal(Integer creditBal) {
		this.creditBal = creditBal;
	}

}