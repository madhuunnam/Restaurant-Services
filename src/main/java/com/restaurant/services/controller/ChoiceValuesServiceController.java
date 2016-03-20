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

import com.restaurant.services.dao.repository.ChoiceValuesRepository;
import com.restaurant.services.model.Choice;
import com.restaurant.services.model.ChoiceValues;
import com.restaurant.services.model.Item;

@RestController
public class ChoiceValuesServiceController {
	
	@Autowired
	ChoiceValuesRepository choiceValuesRepository;
	
	@RequestMapping(value = "/addChoiceValues", method = RequestMethod.POST)
	public ResponseEntity<String> addChoiceValues(@RequestBody ChoiceValues choiceVal) {

		String insertStatus = "ChoiceValues SetUp Success!";
		try {
			choiceValuesRepository.addChoiceValues(choiceVal);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "ChoiceValues SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateChoiceValues", method = RequestMethod.PUT)
	public ResponseEntity<String> updateChoiceValues(@RequestBody ChoiceValues choiceVal) {

		String updateStatus = "ChoiceValues Update Success!";
		try {
			choiceValuesRepository.updateChoiceValues(choiceVal);
		} catch (Exception e) {
			e.printStackTrace();
			updateStatus = "ChoiceValues Update Failed";
		}
		return new ResponseEntity<String>(updateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getChoiceValuesListForChoicesOfRestaurant/{restaurantId}/{chNum}", method = RequestMethod.GET, produces = "application/json")
	public List<ChoiceValues> getChoiceValuesListForChoicesOfRestaurant(@PathVariable("restaurantId") String restaurantId,
			@PathVariable("chNum") String chNum) {
		String sqlStatus = "Sql Success!";
		List<ChoiceValues> choiceValues = null;
		try {
			choiceValues = choiceValuesRepository.getChoiceValuesListForChoicesOfRestaurant(restaurantId, chNum);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return choiceValues;
	}
	
	@RequestMapping(value = "/deleteChoiceValuesForChoicesOfRestaurant/{restaurantId}/{choiceNum}/{valName}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteChoiceValuesForChoicesOfRestaurant(@PathVariable("restaurantId") String restaurantId,
			@PathVariable("choiceNum") String chNum, @PathVariable("valName") String valName) {
		String sqlStatus = "Sql Success!";
		try {
			choiceValuesRepository.deleteChoiceValuesForChoicesOfRestaurant(restaurantId, chNum, valName);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return new ResponseEntity<String>(sqlStatus, HttpStatus.OK);
	}

}
