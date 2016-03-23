package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.CustLedger;

public class CustLedgerMapper implements RowMapper {

	public CustLedger mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustLedger cl = new CustLedger();

		cl.setCustId(rs.getString("custId"));
		cl.setCustName(rs.getString("custName"));
		cl.setLedgerNum(rs.getString("ledgerNum"));
		cl.setLedgerDate(rs.getDate("ledgerDate"));
		cl.setResId(rs.getString("resID"));
		cl.setOrderNum(rs.getString("orderNum"));
		cl.setResName(rs.getString("resName"));
		cl.setChargeAmt(rs.getFloat("chargeAmt"));
		cl.setPayAmt(rs.getFloat("PayAmt"));
		cl.setPayMethod(rs.getString("payMethod"));
		cl.setNote(rs.getString("note"));
		cl.setBalance(rs.getFloat("balance"));

		return cl;

	}
}
