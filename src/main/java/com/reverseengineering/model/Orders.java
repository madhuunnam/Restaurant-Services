package com.reverseengineering.model;
// Generated Mar 16, 2016 6:54:18 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Orders generated by hbm2java
 */
public class Orders implements java.io.Serializable {

	private OrdersId id;
	private Integer custId;
	private String custName;
	private String resName;
	private String orderType;
	private Date orderTime;
	private Integer numberOfLines;
	private String itemName;
	private Float subTot;
	private Float discountPercentage;
	private Float taxRatePercent;
	private Float taxAmount;
	private Float tip;
	private Float deliFee;
	private Float totPrice;
	private String receiverName;
	private String deliAddr;
	private String status;
	private String msgToCust;
	private String msgToRes;
	private Boolean nonSmoke;
	private String resTable;
	private Byte resPeople;
	private Date resTime;
	private Date pickTime;
	private Date arriveTime;
	private String agentName;
	private String notes;

	public Orders() {
	}

	public Orders(OrdersId id, Date orderTime) {
		this.id = id;
		this.orderTime = orderTime;
	}

	public Orders(OrdersId id, Integer custId, String custName, String resName, String orderType, Date orderTime,
			Integer numberOfLines, String itemName, Float subTot, Float discountPercentage, Float taxRatePercent,
			Float taxAmount, Float tip, Float deliFee, Float totPrice, String receiverName, String deliAddr,
			String status, String msgToCust, String msgToRes, Boolean nonSmoke, String resTable, Byte resPeople,
			Date resTime, Date pickTime, Date arriveTime, String agentName, String notes) {
		this.id = id;
		this.custId = custId;
		this.custName = custName;
		this.resName = resName;
		this.orderType = orderType;
		this.orderTime = orderTime;
		this.numberOfLines = numberOfLines;
		this.itemName = itemName;
		this.subTot = subTot;
		this.discountPercentage = discountPercentage;
		this.taxRatePercent = taxRatePercent;
		this.taxAmount = taxAmount;
		this.tip = tip;
		this.deliFee = deliFee;
		this.totPrice = totPrice;
		this.receiverName = receiverName;
		this.deliAddr = deliAddr;
		this.status = status;
		this.msgToCust = msgToCust;
		this.msgToRes = msgToRes;
		this.nonSmoke = nonSmoke;
		this.resTable = resTable;
		this.resPeople = resPeople;
		this.resTime = resTime;
		this.pickTime = pickTime;
		this.arriveTime = arriveTime;
		this.agentName = agentName;
		this.notes = notes;
	}

	public OrdersId getId() {
		return this.id;
	}

	public void setId(OrdersId id) {
		this.id = id;
	}

	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getNumberOfLines() {
		return this.numberOfLines;
	}

	public void setNumberOfLines(Integer numberOfLines) {
		this.numberOfLines = numberOfLines;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getSubTot() {
		return this.subTot;
	}

	public void setSubTot(Float subTot) {
		this.subTot = subTot;
	}

	public Float getDiscountPercentage() {
		return this.discountPercentage;
	}

	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Float getTaxRatePercent() {
		return this.taxRatePercent;
	}

	public void setTaxRatePercent(Float taxRatePercent) {
		this.taxRatePercent = taxRatePercent;
	}

	public Float getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Float getTip() {
		return this.tip;
	}

	public void setTip(Float tip) {
		this.tip = tip;
	}

	public Float getDeliFee() {
		return this.deliFee;
	}

	public void setDeliFee(Float deliFee) {
		this.deliFee = deliFee;
	}

	public Float getTotPrice() {
		return this.totPrice;
	}

	public void setTotPrice(Float totPrice) {
		this.totPrice = totPrice;
	}

	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getDeliAddr() {
		return this.deliAddr;
	}

	public void setDeliAddr(String deliAddr) {
		this.deliAddr = deliAddr;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsgToCust() {
		return this.msgToCust;
	}

	public void setMsgToCust(String msgToCust) {
		this.msgToCust = msgToCust;
	}

	public String getMsgToRes() {
		return this.msgToRes;
	}

	public void setMsgToRes(String msgToRes) {
		this.msgToRes = msgToRes;
	}

	public Boolean getNonSmoke() {
		return this.nonSmoke;
	}

	public void setNonSmoke(Boolean nonSmoke) {
		this.nonSmoke = nonSmoke;
	}

	public String getResTable() {
		return this.resTable;
	}

	public void setResTable(String resTable) {
		this.resTable = resTable;
	}

	public Byte getResPeople() {
		return this.resPeople;
	}

	public void setResPeople(Byte resPeople) {
		this.resPeople = resPeople;
	}

	public Date getResTime() {
		return this.resTime;
	}

	public void setResTime(Date resTime) {
		this.resTime = resTime;
	}

	public Date getPickTime() {
		return this.pickTime;
	}

	public void setPickTime(Date pickTime) {
		this.pickTime = pickTime;
	}

	public Date getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
