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

import com.restaurant.services.dao.SectionRepository;
import com.restaurant.services.model.ChoiceValues;
import com.restaurant.services.model.Section;

@RestController
public class SectionServiceController {

	@Autowired
	SectionRepository sectionRepository;
	
	@RequestMapping(value = "/addSection", method = RequestMethod.POST)
	public ResponseEntity<String> addSection(@RequestBody Section sec) {
System.out.println("In add Section");
		String insertStatus = "Section SetUp Success!";
		try {
			sectionRepository.addSection(sec);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Section SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateSection", method = RequestMethod.PUT)
	public ResponseEntity<String> updateSection(@RequestBody Section sec) {

		String updateStatus = "Section Update Success!";
		try {
			sectionRepository.updateSection(sec);
		} catch (Exception e) {
			e.printStackTrace();
			updateStatus = "Section Update Failed";
		}
		return new ResponseEntity<String>(updateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getSectionListForRestaurant/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Section> getSectionListForRestaurant(@PathVariable("restaurantId") String restaurantId) {
		String sqlStatus = "Sql Success!";
		List<Section> sec = null;
		try {
			sec = sectionRepository.getSectionListForRestaurant(restaurantId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return sec;
	}
	
	@RequestMapping(value = "/deleteSectionForRestaurant/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteSectionForRestaurant(@PathVariable("restaurantId") String restaurant) {
		String sqlStatus = "Sql Success!";
		try {
			sectionRepository.deleteSectionForRestaurant(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return new ResponseEntity<String>(sqlStatus, HttpStatus.OK);
	}
	
}
