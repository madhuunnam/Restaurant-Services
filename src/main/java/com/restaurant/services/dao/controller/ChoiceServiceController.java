package com.restaurant.services.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.ChoiceRepository;
import com.restaurant.services.model.Choice;

@RestController
public class ChoiceServiceController {

	@Autowired
	ChoiceRepository choiceRepository;

	@RequestMapping(value = "/addChoice", method = RequestMethod.POST)
	public ResponseEntity<String> addChoice(@RequestBody Choice choice) {

		String insertStatus = "Choice SetUp Success!";
		try {
			choiceRepository.addChoice(choice);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Choice SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateChoice", method = RequestMethod.PUT)
	public ResponseEntity<String> updateChoice(@RequestBody Choice choice) {

		String updateStatus = "Choice Update Success!";
		try {
			choiceRepository.updateChoice(choice);
		} catch (Exception e) {
			e.printStackTrace();
			updateStatus = "Choice Update Failed";
		}
		return new ResponseEntity<String>(updateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getChoiceListForItemOfRestaurant/{restaurantId}/{itemNum}", method = RequestMethod.GET, produces = "application/json")
	public List<Choice> getChoiceListForItemOfRestaurant(@PathVariable("restaurantId") String restaurantId,
			@PathVariable("itemNum") String itemNo) {
		String sqlStatus = "Sql Success!";
		List<Choice> choices = null;
		try {
			choices = choiceRepository.getChoiceListForItemOfRestaurant(restaurantId, itemNo);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return choices;
	}

	@RequestMapping(value = "/deleteChoiceForItemOfRestaurant/{restaurantId}/{itemNum}/{choiceNum}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteChoiceForItemOfRestaurant(@PathVariable("restaurantId") String restaurantId,
			@PathVariable("itemNum") String itemNo, @PathVariable("choiceNum") String chNum) {
		String sqlStatus = "Sql Success!";
		try {
			choiceRepository.deleteChoiceForItemOfRestaurant(restaurantId, itemNo, chNum);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return new ResponseEntity<String>(sqlStatus, HttpStatus.OK);
	}
}
