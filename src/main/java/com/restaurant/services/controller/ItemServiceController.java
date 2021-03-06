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

import com.restaurant.services.dao.repository.ItemRepository;
import com.restaurant.services.model.Item;

@RestController
public class ItemServiceController {

	@Autowired
	ItemRepository itemRepository;

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

		String insertStatus = "Item update Success!";
		try {
			itemRepository.updateItem(item);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Item update Failed";
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
	
	@RequestMapping(value = "/getItemDetailsById/{restId}/{itemNum}", method = RequestMethod.GET, produces = "application/json")
	public Item getItemDetailsById(@PathVariable("restId") String restId , @PathVariable("itemNum") String itemNum){
		Item item= new Item();
		try {
			item = itemRepository.getItemDetailsById(restId, itemNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}

	@RequestMapping(value = "/deleteItemFromRestaurant/{restaurantId}/{itemNum}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteItemFromRestaurant(@PathVariable("restaurantId") String restaurantId,
			@PathVariable("itemNum") String itemNo) {
		String sqlStatus = "Sql Success!";
		try {
			itemRepository.deleteItemFromRestaurant(restaurantId, itemNo);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return new ResponseEntity<String>(sqlStatus, HttpStatus.OK);
	}

}
