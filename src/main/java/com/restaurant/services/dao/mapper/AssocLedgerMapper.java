package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.AssocLedger;

public class AssocLedgerMapper implements RowMapper {

	public AssocLedger mapRow(ResultSet rs, int rowNum) throws SQLException {

		AssocLedger al = new AssocLedger();

		al.setAssocId(rs.getString("assocID"));
		al.setAssocName(rs.getString("assocName"));
		al.setResId(rs.getString("resID"));
		al.setResName(rs.getString("resName"));
		al.setLedgerNum(rs.getString("ledgerNum"));
		al.setLedgerDate(rs.getDate("ledgerDate"));
		al.setComAmt(rs.getFloat("comAmt"));
		al.setOverrideAmt(rs.getFloat("overrideAmt"));
		al.setOverrideId(rs.getString("overrideID"));
		al.setOverrideName(rs.getString("overrideName"));
		al.setChargeAmt(rs.getFloat("chargeAmt"));
		al.setPayAmt(rs.getFloat("PayAmt"));
		al.setPayMethod(rs.getString("payMethod"));
		al.setCheckNum(rs.getString("checkNum"));
		al.setNote(rs.getString("note"));
		al.setBalance(rs.getFloat("balance"));

		return al;

	}

}
