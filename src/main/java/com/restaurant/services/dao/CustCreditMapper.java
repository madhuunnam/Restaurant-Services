package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.CustCredit;

public class CustCreditMapper implements RowMapper{
	
public CustCredit mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CustCredit cc = new CustCredit();
		
		cc.setCustID(rs.getString("custID"));
		cc.setAddr2(rs.getString("addr2"));
		cc.setAddr3(rs.getString("addr3"));
		cc.setAddr4(rs.getString("addr4"));
		cc.setNumCust(rs.getInt("numCust"));
		cc.setNumRes(rs.getInt("numRes"));
		cc.setNumRev(rs.getInt("numRev"));
		cc.setNumOrders(rs.getInt("numOrders"));
		cc.setTotCredits(rs.getInt("totCredits"));
		cc.setCreditBal(rs.getInt("creditBal"));
		
		return cc;
	}
}
