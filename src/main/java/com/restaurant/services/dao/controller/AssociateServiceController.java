package com.restaurant.services.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.AssociateRepository;
import com.restaurant.services.model.Admin;
import com.restaurant.services.model.Associate;

@RestController
public class AssociateServiceController {

	@Autowired
	AssociateRepository assocRepository;

	@RequestMapping(value = "/signUpAssociate", method = RequestMethod.POST)
	public ResponseEntity<String> registerAssociate(@RequestBody Associate assoc) {
		String assocInsertStatus = "Associate Regitration Success! Please Login";
		try {
			assocRepository.registerAssociate(assoc);
		} catch (Exception e) {
			e.printStackTrace();
			assocInsertStatus = "Associate Registration Failed";
		}
		return new ResponseEntity<String>(assocInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAssociateProfile", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAssociate(@RequestBody Associate associate) {
		String associateUpdateStatus = "Associate Update Success!";
		try {
			assocRepository.updateAssociate(associate);
		} catch (Exception e) {
			e.printStackTrace();
			associateUpdateStatus = "Associate Update Failed";
		}
		return new ResponseEntity<String>(associateUpdateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAssociate/{assocEmail:.+}", method = RequestMethod.GET, produces = "application/json")
	public Associate getAssociate(@PathVariable("assocEmail") String assocEmail) {
		String sqlStatus = "Sql Success!";
		Associate associate = new Associate();
		try {
			associate = assocRepository.getAssociate(assocEmail);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return associate;
	}
	
	@RequestMapping(value = "/getNewAssociateId", method = RequestMethod.GET, produces = "application/json")
	public String getNewAssociateId() {
		
		String sqlStatus = "Sql Success!";
		String assocId="";
		try {
			assocId = assocRepository.getNewAssociateId();
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return assocId;
	}
}
