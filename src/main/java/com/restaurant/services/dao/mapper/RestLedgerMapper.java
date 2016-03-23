package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.RestLedger;

public class RestLedgerMapper implements RowMapper {

	public RestLedger mapRow(ResultSet rs, int rowNum) throws SQLException {

		RestLedger rl = new RestLedger();

		rl.setRestId(rs.getString("resID"));
		rl.setOrderNum(rs.getString("orderNum"));
		rl.setLedgerNum(rs.getString("ledgerNum"));
		rl.setLedgerDate(rs.getDate("ledgerDate"));
		rl.setCustName(rs.getString("custName"));
		rl.setChargeAmt(rs.getFloat("chargeAmt"));
		rl.setPayAmt(rs.getFloat("PayAmt"));
		rl.setPayMethod(rs.getString("payMethod"));
		rl.setCheckNum(rs.getString("checkNum"));
		rl.setNote(rs.getString("note"));
		rl.setBalance(rs.getFloat("balance"));

		return rl;
	}

}
