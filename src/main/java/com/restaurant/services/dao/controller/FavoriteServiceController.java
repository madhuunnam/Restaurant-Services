package com.restaurant.services.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.FavoriteRepository;
import com.restaurant.services.model.Favorite;

@RestController
public class FavoriteServiceController {
	
	@Autowired
	FavoriteRepository favoriteRepository;

	@RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
	public ResponseEntity<String> addFavorite(@RequestBody Favorite fav) {

		String insertStatus = "Fav SetUp Success!";
		try {
			favoriteRepository.addFavorite(fav);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Fav SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getFavRestaurantsForCustomer/{custId}", method = RequestMethod.GET, produces = "application/json")
	public List<Favorite> getFavRestaurantsForCustomer(@PathVariable("custId") String custId) {
		String sqlStatus = "Sql Success!";
		List<Favorite> favs = null;
		try {
			favs = favoriteRepository.getFavRestaurantsForCustomer(custId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return favs;
	}

	@RequestMapping(value = "/deleteFavRestaurantForCust/{custId}/{restId}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteFavRestaurantForCust(@PathVariable("restId") String restaurantId,
			@PathVariable("custId") String custId) {
		String sqlStatus = "Sql Success!";
		try {
			favoriteRepository.deleteFavRestaurantForCust(restaurantId, custId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return new ResponseEntity<String>(sqlStatus, HttpStatus.OK);
	}

}
