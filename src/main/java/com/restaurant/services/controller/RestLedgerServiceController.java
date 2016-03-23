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

import com.restaurant.services.dao.repository.RestLedgerRepository;
import com.restaurant.services.model.RestLedger;

@RestController
public class RestLedgerServiceController {

	@Autowired
	RestLedgerRepository restLedgerRepository;

	@RequestMapping(value = "/addToRestLedger", method = RequestMethod.POST)
	public ResponseEntity<String> addToRestLedger(@RequestBody RestLedger rLedger) {
		String restInsertStatus = "RestLedger Insert Success";
		try {
			restLedgerRepository.addToRestLedger(rLedger);
		} catch (Exception e) {
			e.printStackTrace();
			restInsertStatus = "RestLedger Insert Failed";
		}
		return new ResponseEntity<String>(restInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getRestLedgerListForRest/{restID}/{toDate}/{fromDate}", method = RequestMethod.GET, produces = "application/json")
	public List<RestLedger> getRestLedgerListForRest(@PathVariable("restID") String restId,
			@PathVariable("toDate") String toDate, @PathVariable("fromDate") String fromDate) {
		System.out.println("In RestLedgerService");
		String sqlStatus = "Sql Success!";
		List<RestLedger> rLedgers = null;
		try {
			rLedgers = restLedgerRepository.getRestLedgerListForRest(restId, toDate, fromDate);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		System.out.println(rLedgers);
		return rLedgers;
	}

}
