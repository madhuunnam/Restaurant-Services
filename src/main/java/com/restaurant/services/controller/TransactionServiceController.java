package com.restaurant.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.TransactionRepository;
import com.restaurant.services.model.Transaction;

@RestController
public class TransactionServiceController {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public ResponseEntity<String> addTransaction(@RequestBody Transaction tran) {

		String insertStatus = "Transaction SetUp Success!";
		try {
			transactionRepository.addTransaction(tran);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Transaction SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}
	
	

}
