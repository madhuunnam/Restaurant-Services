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

import com.restaurant.services.dao.repository.AssocLedgerRepository;
import com.restaurant.services.model.AssocLedger;

@RestController
public class AssocLedgerServiceController {

	@Autowired
	AssocLedgerRepository assocLedgerRepository;

	@RequestMapping(value = "/addToAssocLedger", method = RequestMethod.POST)
	public ResponseEntity<String> addToAssocLedger(@RequestBody AssocLedger aLedger) {
		String AssocInsertStatus = "AssocLedger Insert Success";
		try {
			assocLedgerRepository.addToAssocLedger(aLedger);
		} catch (Exception e) {
			e.printStackTrace();
			AssocInsertStatus = "AssocLedger Insert Failed";
		}
		return new ResponseEntity<String>(AssocInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAssocLedgerListForAssocomer/{AssocID}/{toDate}/{fromDate}", method = RequestMethod.GET, produces = "application/json")
	public List<AssocLedger> getAssocLedgerListForAssocomer(@PathVariable("AssocID") String assocId,
			@PathVariable("toDate") String toDate, @PathVariable("fromDate") String fromDate) {

		System.out.println("In AssocLedgerService");
		String sqlStatus = "Sql Success!";
		List<AssocLedger> aLedgers = null;
		try {
			aLedgers = assocLedgerRepository.getAssocLedgerListForAssocomer(assocId, toDate, fromDate);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		System.out.println(aLedgers);
		return aLedgers;
	}

}
