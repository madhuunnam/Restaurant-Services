package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.AdminLedgerMapper;
import com.restaurant.services.model.AdminLedger;

@Component
public class AdminLedgerRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_ADMINLEDGER_RECORDS = "INSERT INTO AdminLedgers(ledgerID, custID, custName, resID, "
			+ "resName, assocID, assocName, orderNum, ledgerNum, ledgerDate, income, inMethod, inNote, expense, exMethod, "
			+ "exNote, note, balance) VALUES (:ledgerID,:custID,:custName,:resID,:resName,:assocID,:assocName,"
			+ ":orderNum,:ledgerNum,:ledgerDate,:income,:inMethod,:inNote,:expense,:exMethod,:exNote,:note,"
			+ ":balance)";

	public void addToAdminLedger(AdminLedger aLedger) {

		Map<String, Object> paramMap = createParameterMap(aLedger);

		try {
			namedParameterTemplate.update(INSERT_ADMINLEDGER_RECORDS, paramMap);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<AdminLedger> getAdminLedgerList(String toDate, String fromDate) {
		String SQL = "SELECT * FROM AdminLedgers where ledgerDate BETWEEN :toDate AND :fromDate ";

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);

		List<AdminLedger> aLedgers = (List<AdminLedger>) namedParameterTemplate.query(SQL, paramMap,
				new AdminLedgerMapper());
		return aLedgers;
	}

	private Map<String, Object> createParameterMap(AdminLedger aLedger) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("ledgerID", aLedger.getLedgerId());
		paramMap.put("custID", aLedger.getCustId());
		paramMap.put("custName", aLedger.getCustName());
		paramMap.put("resID", aLedger.getResId());
		paramMap.put("resName", aLedger.getResName());
		paramMap.put("assocID", aLedger.getAssocId());
		paramMap.put("assocName", aLedger.getAssocName());
		paramMap.put("orderNum", aLedger.getOrderNum());
		paramMap.put("ledgerNum", aLedger.getLedgerNum());
		paramMap.put("ledgerDate", aLedger.getLedgerDate());
		paramMap.put("income", aLedger.getIncome());
		paramMap.put("inMethod", aLedger.getInMethod());
		paramMap.put("inNote", aLedger.getInNote());
		paramMap.put("expense", aLedger.getExpense());
		paramMap.put("exMethod", aLedger.getExMethod());
		paramMap.put("exNote", aLedger.getExNote());
		paramMap.put("note", aLedger.getNote());
		paramMap.put("balance", aLedger.getBalance());

		return paramMap;

	}

}
