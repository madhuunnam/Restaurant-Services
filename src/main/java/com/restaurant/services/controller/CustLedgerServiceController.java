package com.restaurant.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.CustLedgerRepository;
import com.restaurant.services.model.CustLedger;

@RestController
public class CustLedgerServiceController {

	@Autowired
	CustLedgerRepository custLedgerRepository;

	@RequestMapping(value = "/addToCustLedger", method = RequestMethod.POST)
	public ResponseEntity<String> addToCustLedger(@RequestBody CustLedger cLedger) {
		String custInsertStatus = "CustLedger Insert Success";
		try {
			custLedgerRepository.addToCustLedger(cLedger);
		} catch (Exception e) {
			e.printStackTrace();
			custInsertStatus = "CustLedger Insert Failed";
		}
		return new ResponseEntity<String>(custInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCustLedgerListForCustomer/{custID}/{toDate}/{fromDate}", method = RequestMethod.GET, produces = "application/json")
	public List<CustLedger> getCustLedgerListForCustomer(@PathVariable("custID") String custId,
			@PathVariable("toDate") String toDate, @PathVariable("fromDate") String fromDate) {
		System.out.println("In CustLedgerService");
		String sqlStatus = "Sql Success!";
		List<CustLedger> cLedgers = null;
		try {
			cLedgers = custLedgerRepository.getCustLedgerListForCustomer(custId, toDate, fromDate);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		System.out.println(cLedgers);
		return cLedgers;
	}

}
