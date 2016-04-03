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

import com.restaurant.services.dao.repository.LineItemRepository;
import com.restaurant.services.model.LineItem;

@RestController
public class LineItemServiceController {

	@Autowired
	LineItemRepository lineItemRepository;

	@RequestMapping(value = "/addLineItem", method = RequestMethod.POST)
	public ResponseEntity<String> addLineItem(@RequestBody LineItem lineItem) {

		String insertStatus = "LineItem SetUp Success!";
		try {
			lineItemRepository.addLineItem(lineItem);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "LineItem SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}


	@RequestMapping(value = "/getLineItemsForRestaurantOrder/{restId}/{orderNo}", method = RequestMethod.GET, produces = "application/json")
	public List<LineItem> getLineItemsForRestaurantOrder(@PathVariable("restId") String restId,
			@PathVariable("orderNo") String orderNum) {
		List<LineItem> lineItem = null;
		try {
			lineItem = lineItemRepository.getLineItemsForRestaurantOrder(restId, orderNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lineItem;
	}
}
