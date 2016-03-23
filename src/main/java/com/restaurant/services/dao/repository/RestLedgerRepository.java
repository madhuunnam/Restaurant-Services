package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.RestLedgerMapper;
import com.restaurant.services.model.RestLedger;

@Component
public class RestLedgerRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_RESTLEDGER_RECORDS = "INSERT INTO ResLedgers(resID, orderNum, resName, ledgerNum, "
			+ "ledgerDate, custName, chargeAmt, PayAmt, payMethod, checkNum, note, balance) VALUES (:restId,:orderNum,"
			+ ":resName,:ledgerNum,:ledgerDate,:custName,:chargeAmt,:PayAmt,:payMethod,:checkNum,:note,:balance)";

	public void addToRestLedger(RestLedger rLedger) {

		Map<String, Object> paramMap = createParameterMap(rLedger);

		try {
			namedParameterTemplate.update(INSERT_RESTLEDGER_RECORDS, paramMap);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<RestLedger> getRestLedgerListForRest(String restId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM ResLedgers where resID =:restID and ledgerDate BETWEEN :toDate AND :fromDate ";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restID", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<RestLedger> rLedgers = (List<RestLedger>) namedParameterTemplate.query(SQL, paramMap,
				new RestLedgerMapper());
		return rLedgers;
	}

	private Map<String, Object> createParameterMap(RestLedger rLedger) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("restId", rLedger.getRestId());
		paramMap.put("orderNum", rLedger.getOrderNum());
		paramMap.put("resName", rLedger.getResName());
		paramMap.put("ledgerNum", rLedger.getLedgerNum());
		paramMap.put("ledgerDate", rLedger.getLedgerDate());
		paramMap.put("custName", rLedger.getCustName());
		paramMap.put("chargeAmt", rLedger.getChargeAmt());
		paramMap.put("PayAmt", rLedger.getPayAmt());
		paramMap.put("payMethod", rLedger.getPayMethod());
		paramMap.put("checkNum", rLedger.getCheckNum());
		paramMap.put("note", rLedger.getNote());
		paramMap.put("balance", rLedger.getBalance());

		return paramMap;

	}

}
