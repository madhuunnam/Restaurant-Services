package com.restaurant.services.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.AssocPerfRepository;
import com.restaurant.services.model.AssocPerf;

@RestController
public class AssocPerfServiceController {

	@Autowired
	AssocPerfRepository assocPerfRepository;

	@RequestMapping(value = "/addToAssocPerf/{assocID}", method = RequestMethod.POST)
	public ResponseEntity<String> addToAssocPerf(@RequestBody AssocPerf assocPerf,
			@PathVariable("assocID") String assocId) {

		String assocPerfInsertStatus = "AssocPerf Insert Success!";
		try {
			assocPerfRepository.addToAssocPerf(assocPerf, assocId);
		} catch (Exception e) {
			e.printStackTrace();
			assocPerfInsertStatus = "AssocPerf Insert Failed";
		}
		return new ResponseEntity<String>(assocPerfInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAssocPerf", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAssocPerf(@RequestBody AssocPerf assocPerf) {
		String assocPerfUpdateStatus = "AssocPerf Update Success!";
		try {
			assocPerfRepository.updateAssocPerf(assocPerf);
		} catch (Exception e) {
			e.printStackTrace();
			assocPerfUpdateStatus = "AssocPerf Update Failed";
		}
		return new ResponseEntity<String>(assocPerfUpdateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAssocPerf/{assocId}", method = RequestMethod.GET, produces = "application/json")
	public AssocPerf getAssocPerf(@PathVariable("assocId") String assocId) {
		String sqlStatus = "Sql Success!";
		AssocPerf assocPerf = new AssocPerf();
		try {
			assocPerf = assocPerfRepository.getAssocPerf(assocId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return assocPerf;
	}
}
