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

import com.restaurant.services.dao.repository.TransactionRepository;
import com.restaurant.services.model.Order;
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
	
	@RequestMapping(value = "/getPickUpOrdersTotalPrice/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getPickUpOrdersTotalPrice(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String pickUpSum="";
		try {
			pickUpSum = transactionRepository.getPickUpOrdersTotalPrice(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return pickUpSum;
	}
	
	@RequestMapping(value = "/getNumberOfPickUpOrders/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getNumberOfPickUpOrders(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String noOfpickUpOrders="";
		try {
			noOfpickUpOrders = transactionRepository.getNumberOfPickUpOrders(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return noOfpickUpOrders;
	}
	
	@RequestMapping(value = "/getDeliveryOrdersTotalPrice/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getDeliveryOrdersTotalPrice(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String deliverySum="";
		try {
			deliverySum = transactionRepository.getDeliveryOrdersTotalPrice(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return deliverySum;
	}
	
	@RequestMapping(value = "/getNumberOfDeliveryOrders/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getNumberOfDeliveryOrders(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String noOfDeliveryOrders="";
		try {
			noOfDeliveryOrders = transactionRepository.getNumberOfDeliveryOrders(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return noOfDeliveryOrders;
	}
	
	@RequestMapping(value = "/getReservationOrdersTotalPrice/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getReservationOrdersTotalPrice(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String reservationSum="";
		try {
			reservationSum = transactionRepository.getReservationOrdersTotalPrice(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return reservationSum;
	}
	
	@RequestMapping(value = "/getNumberOfReservationOrders/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getNumberOfReservationOrders(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String noOfReservationOrders="";
		try {
			noOfReservationOrders = transactionRepository.getNumberOfReservationOrders(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return noOfReservationOrders;
	}
	@RequestMapping(value = "/getOrdersTotalPrice/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getOrdersTotalPrice(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String totalSum="";
		try {
			totalSum = transactionRepository.getOrdersTotalPrice(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return totalSum;
	}
	
	@RequestMapping(value = "/getNumberOfOrders/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public String getNumberOfOrders(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		String noOfOrders="";
		try {
			noOfOrders = transactionRepository.getNumberOfOrders(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return noOfOrders;
	}
	
	@RequestMapping(value = "/getPickUpOrderList/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Transaction> getPickUpOrderList(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		List<Transaction> transactions = null;
		try {
			transactions = transactionRepository.getPickUpOrderList(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return transactions;
	}
	@RequestMapping(value = "/getDeliveryOrderList/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Transaction> getDeliveryOrderList(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		List<Transaction> transactions = null;
		try {
			transactions = transactionRepository.getDeliveryOrderList(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return transactions;
	}
	@RequestMapping(value = "/getReservationOrderList/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Transaction> getReservationOrderList(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		List<Transaction> transactions = null;
		try {
			transactions = transactionRepository.getReservationOrderList(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return transactions;
	}
	@RequestMapping(value = "/getTotalOrderList/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Transaction> getTotalOrderList(@PathVariable("restaurantId") String restId) {
		
		String sqlStatus = "Sql Success!";
		List<Transaction> transactions = null;
		try {
			transactions = transactionRepository.getTotalOrderList(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return transactions;
	}
	

}
