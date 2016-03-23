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

import com.restaurant.services.dao.repository.AdminLedgerRepository;
import com.restaurant.services.model.AdminLedger;

@RestController
public class AdminLedgerServiceController {
	
	@Autowired
	AdminLedgerRepository adminLedgerRepository;

	@RequestMapping(value = "/addToAdminLedger", method = RequestMethod.POST)
	public ResponseEntity<String> addToAdminLedger(@RequestBody AdminLedger aLedger) {
		String AdminInsertStatus = "AdminLedger Insert Success";
		try {
			adminLedgerRepository.addToAdminLedger(aLedger);
		} catch (Exception e) {
			e.printStackTrace();
			AdminInsertStatus = "AdminLedger Insert Failed";
		}
		return new ResponseEntity<String>(AdminInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAdminLedgerList/{toDate}/{fromDate}", method = RequestMethod.GET, produces = "application/json")
	public List<AdminLedger> getAdminLedgerList(@PathVariable("toDate") String toDate, @PathVariable("fromDate") String fromDate) {

		System.out.println("In AdminLedgerService");
		String sqlStatus = "Sql Success!";
		List<AdminLedger> aLedgers = null;
		try {
			aLedgers = adminLedgerRepository.getAdminLedgerList(toDate, fromDate);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		System.out.println(aLedgers);
		return aLedgers;
	}

}
