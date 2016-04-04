package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Transaction;

public class TransactionMapper implements RowMapper {

	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {

		Transaction or = new Transaction();
		or.setRestId(rs.getString("resID"));
		or.setOrderNo(rs.getString("orderNum"));
		or.setCustId(rs.getString("custId"));
		or.setCustName(rs.getString("custName"));
		or.setResName(rs.getString("resName"));
		or.setOrderType(rs.getString("orderType"));
		or.setOrderTime(rs.getDate("orderTime"));
		or.setNumberOfLines(rs.getInt("numberOfLines"));
		or.setItemName(rs.getString("itemName"));
		or.setSubTot(rs.getFloat("subTot"));
		or.setDiscountPercentage(rs.getFloat("discountPercentage"));
		or.setTaxRatePercent(rs.getFloat("taxRatePercent"));
		or.setTaxAmount(rs.getFloat("taxAmount"));
		or.setTip(rs.getFloat("tip"));
		or.setDeliFee(rs.getFloat("deliFee"));
		or.setTotPrice(rs.getFloat("totPrice"));
		or.setReceiverName(rs.getString("receiverName"));
		or.setDeliAddr(rs.getString("deliAddr"));
		or.setStatus(rs.getString("status"));
		or.setMsgToCust(rs.getString("msgToCust"));
		or.setMsgToRes(rs.getString("msgToRes"));
		or.setNonSmoke(rs.getBoolean("nonSmoke"));
		or.setResTable(rs.getString("resTable"));
		or.setResPeople(rs.getByte("resPeople"));
		or.setResTime(rs.getDate("resTime"));
		or.setPickTime(rs.getDate("pickTime"));
		or.setArriveTime(rs.getDate("arriveTime"));
		or.setAgentName(rs.getString("agentName"));
		or.setNotes(rs.getString("notes"));

		return or;
	}
}
