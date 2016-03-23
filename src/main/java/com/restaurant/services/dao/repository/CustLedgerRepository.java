package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.CustLedgerMapper;
import com.restaurant.services.model.CustLedger;

@Component
public class CustLedgerRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	private static final String INSERT_CUSTLEDGER_RECORDS = "INSERT INTO CustLedgers(custId, custName, ledgerNum, ledgerDate, "
			+ "resID, orderNum, resName, chargeAmt, PayAmt, payMethod, note, balance) VALUES (:custId,:custName,"
			+ ":ledgerNum,:ledgerDate,:resID,:orderNum,:resName,:chargeAmt,:PayAmt,:payMethod,:note,:balance)";

	public void addToCustLedger(CustLedger cLedger) {

		Map<String, Object> paramMap = createParameterMap(cLedger);

		try {
			namedParameterTemplate.update(INSERT_CUSTLEDGER_RECORDS, paramMap);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<CustLedger> getCustLedgerListForCustomer(String custId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM CustLedgers where custId =:custID and ledgerDate BETWEEN :toDate AND :fromDate ";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custID", custId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<CustLedger> cLedgers = (List<CustLedger>) namedParameterTemplate.query(SQL, paramMap,
				new CustLedgerMapper());
		return cLedgers;
	}

	private Map<String, Object> createParameterMap(CustLedger cLedger) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("custId", cLedger.getCustId());
		paramMap.put("custName", cLedger.getCustName());
		paramMap.put("ledgerNum", cLedger.getLedgerNum());
		paramMap.put("ledgerDate", cLedger.getLedgerDate());
		paramMap.put("resID", cLedger.getResId());
		paramMap.put("orderNum", cLedger.getOrderNum());
		paramMap.put("resName", cLedger.getResName());
		paramMap.put("chargeAmt", cLedger.getChargeAmt());
		paramMap.put("PayAmt", cLedger.getPayAmt());
		paramMap.put("payMethod", cLedger.getPayMethod());
		paramMap.put("note", cLedger.getNote());
		paramMap.put("balance", cLedger.getBalance());

		return paramMap;

	}
}
