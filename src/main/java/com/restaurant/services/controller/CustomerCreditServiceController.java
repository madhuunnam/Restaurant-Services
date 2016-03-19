package com.restaurant.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.CustCreditRepository;
import com.restaurant.services.model.CustCredit;

@RestController
public class CustomerCreditServiceController {

	@Autowired
	CustCreditRepository custCreditRepository;

	@RequestMapping(value = "/addToCustCredit/{custID}", method = RequestMethod.POST)
	public ResponseEntity<String> addToCustCredit(@RequestBody CustCredit custCredit,
			@PathVariable("custID") String custId) {

		String custCreditInsertStatus = "CustCredit Insert Success!";
		try {
			custCreditRepository.addToCustCredit(custCredit, custId);
		} catch (Exception e) {
			e.printStackTrace();
			custCreditInsertStatus = "CustCredit Insert Failed";
		}
		return new ResponseEntity<String>(custCreditInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateCustCredit", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCustCredit(@RequestBody CustCredit custCredit) {
		String custCreditUpdateStatus = "CustCredit Update Success!";
		try {
			custCreditRepository.updateCustCredit(custCredit);
		} catch (Exception e) {
			e.printStackTrace();
			custCreditUpdateStatus = "CustCredit Update Failed";
		}
		return new ResponseEntity<String>(custCreditUpdateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCustCredit/{custId}", method = RequestMethod.GET, produces = "application/json")
	public CustCredit getCustCredit(@PathVariable("custId") String custId) {
		String sqlStatus = "Sql Success!";
		CustCredit custCredit = new CustCredit();
		try {
			custCredit = custCreditRepository.getCustCredit(custId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return custCredit;
	}
}
