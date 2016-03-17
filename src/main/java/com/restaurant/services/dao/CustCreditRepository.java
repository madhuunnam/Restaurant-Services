package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.CustCredit;
import com.restaurant.services.model.RestAdmin;

@Component
public class CustCreditRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_CUSTCREDIT_RECORDS = "INSERT INTO Credits(custID, addr2, addr3, addr4, numCust, numRes,"
			+ " numRev, numOrders, totCredits, creditBal) VALUES (:custId,:addr2,:addr3,:addr4,:numCust,:numRes,:numRev,"
			+ ":numOrders,:totCredits,:creditBal)";

	private static final String UPDATE_CUSTCREDIT_RECORDS = "UPDATE Credits SET addr2=:addr2,addr3=:addr3,addr4=:addr4,numCust=:numCust,"
			+ "numRes=:numRes,numRev=:numRev,numOrders=:numOrders,totCredits=:totCredits,creditBal=:creditBal "
			+ "WHERE custID=:custId";

	public void addToCustCredit(CustCredit custCredit, String custId) {

		Map<String, Object> paramMap = createParameterMap(custCredit);
		paramMap.put("custId", custId);
		namedParameterTemplate.update(INSERT_CUSTCREDIT_RECORDS, paramMap);
	}

	public void updateCustCredit(CustCredit custCredit) {

		Map<String, Object> paramMap = createParameterMap(custCredit);
		paramMap.put("custId", custCredit.getCustID());
		namedParameterTemplate.update(UPDATE_CUSTCREDIT_RECORDS, paramMap);
	}

	public CustCredit getCustCredit(String custId) {
		String SQL = "SELECT * FROM Credits WHERE custID = :custId ";

		SqlParameterSource namedParameters = new MapSqlParameterSource("custId", custId);

		CustCredit custCredit = (CustCredit) namedParameterTemplate.queryForObject(SQL, namedParameters,
				new CustCreditMapper());
		return custCredit;
	}

	private Map<String, Object> createParameterMap(CustCredit custCredit) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		// paramMap.put("restId", restAdmin.getRestID());
		paramMap.put("addr2", custCredit.getAddr2());
		paramMap.put("addr3", custCredit.getAddr3());
		paramMap.put("addr4", custCredit.getAddr4());
		paramMap.put("numCust", custCredit.getNumCust());
		paramMap.put("numRes", custCredit.getNumRes());
		paramMap.put("numRev", custCredit.getNumRev());
		paramMap.put("numOrders", custCredit.getNumOrders());
		paramMap.put("totCredits", custCredit.getTotCredits());
		paramMap.put("creditBal", custCredit.getCreditBal());
		
		return paramMap;
	}
}
