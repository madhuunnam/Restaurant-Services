package com.restaurant.services.dao.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.ItemRepository;
import com.restaurant.services.model.Choice;
import com.restaurant.services.model.ChoiceValues;
import com.restaurant.services.model.Item;
import com.restaurant.services.model.Restaurant;

@RestController
public class ItemServiceController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@RequestMapping(value = "/pingItem", method = RequestMethod.GET, produces = "application/json")
	public Item ping() {

		Item admin = new Item();
		admin.setItemName("Dosa");
		admin.setNumChoice(1);

		return admin;
	}


	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ResponseEntity<String> addItem(@RequestBody Item item) {

		String insertStatus = "Item SetUp Success!";
		try {
			itemRepository.addItem(item);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Item SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
	public ResponseEntity<String> udpateItem(@RequestBody Item item) {

		String insertStatus = "Item SetUp Success!";
		try {
			itemRepository.updateItem(item);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Item SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getItemListForRestaurant/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Item> getItemListForRestaurant(@PathVariable("restaurantId") String restaurantId) {
		String sqlStatus = "Sql Success!";
		List<Item> items = null;
		try {
			items = itemRepository.getItemListForRestaurant(restaurantId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return items;
	}
	
	
}
