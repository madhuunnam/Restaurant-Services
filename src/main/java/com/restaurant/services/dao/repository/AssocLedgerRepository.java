package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.AssocLedgerMapper;
import com.restaurant.services.model.AssocLedger;

@Component
public class AssocLedgerRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	private static final String INSERT_ASSOCLEDGER_RECORDS = "INSERT INTO AssocLedgers(assocID, assocName, resID, resName, "
			+ "ledgerNum, ledgerDate, comAmt, overrideAmt, overrideID, overrideName, chargeAmt, PayAmt, payMethod, checkNum, "
			+ "note, balance) VALUES (:assocID,:assocName,:resID,:resName,:ledgerNum,:ledgerDate,:comAmt,:overrideAmt,"
			+ ":overrideID,:overrideName,:chargeAmt,:PayAmt,:payMethod,:checkNum,:note,:balance)";

	public void addToAssocLedger(AssocLedger aLedger) {

		Map<String, Object> paramMap = createParameterMap(aLedger);

		try {
			namedParameterTemplate.update(INSERT_ASSOCLEDGER_RECORDS, paramMap);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<AssocLedger> getAssocLedgerListForAssocomer(String assocId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM AssocLedgers where assocID =:assocID and ledgerDate BETWEEN :toDate AND :fromDate ";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("assocID", assocId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<AssocLedger> cLedgers = (List<AssocLedger>) namedParameterTemplate.query(SQL, paramMap,
				new AssocLedgerMapper());
		return cLedgers;
	}

	private Map<String, Object> createParameterMap(AssocLedger aLedger) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("assocID", aLedger.getAssocId());
		paramMap.put("assocName", aLedger.getAssocName());
		paramMap.put("resID", aLedger.getResId());
		paramMap.put("resName", aLedger.getResName());
		paramMap.put("ledgerNum", aLedger.getLedgerNum());
		paramMap.put("ledgerDate", aLedger.getLedgerDate());
		paramMap.put("comAmt", aLedger.getComAmt());
		paramMap.put("overrideAmt", aLedger.getOverrideAmt());
		paramMap.put("overrideID", aLedger.getOverrideId());
		paramMap.put("overrideName",aLedger.getOverrideName());
		paramMap.put("chargeAmt", aLedger.getChargeAmt());
		paramMap.put("PayAmt", aLedger.getPayAmt());
		paramMap.put("payMethod", aLedger.getPayMethod());
		paramMap.put("checkNum", aLedger.getCheckNum());
		paramMap.put("note", aLedger.getNote());
		paramMap.put("balance", aLedger.getBalance());

		return paramMap;

	}
}
