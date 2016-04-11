package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.AdminLedger;

public class AdminLedgerMapper implements RowMapper {

	public AdminLedger mapRow(ResultSet rs, int rowNum) throws SQLException {

		AdminLedger al = new AdminLedger();

		al.setLedgerId(rs.getString("ledgerID"));
		al.setCustId(rs.getString("custID"));
		al.setCustName(rs.getString("custName"));
		al.setAssocId(rs.getString("assocID"));
		al.setAssocName(rs.getString("assocName"));
		al.setResId(rs.getString("resID"));
		al.setResName(rs.getString("resName"));
		al.setOrderNum(rs.getString("orderNum"));
		al.setLedgerDate(rs.getDate("ledgerDate"));

		al.setIncome(rs.getFloat("income"));
		al.setInMethod(rs.getString("inMethod"));
		al.setInNote(rs.getString("inNote"));
		al.setExpense(rs.getFloat("expense"));
		al.setExMethod(rs.getString("exMethod"));
		al.setExNote(rs.getString("exNote"));
		al.setNote(rs.getString("note"));
		al.setBalance(rs.getFloat("balance"));

		return al;

	}

}
