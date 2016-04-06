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

import com.restaurant.services.dao.repository.OrderRepository;
import com.restaurant.services.model.Order;

@RestController
public class OrderServiceController {

	@Autowired
	OrderRepository orderRepository;

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ResponseEntity<String> addOrder(@RequestBody Order order) {

		String insertStatus = "Order SetUp Success!";
		try {
			orderRepository.addOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Order SetUp Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
	public ResponseEntity<String> updateOrder(@RequestBody Order order) {

		String insertStatus = "Order update Success!";
		try {
			orderRepository.updateOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Order update Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getOrderListForCustomer/{custID}", method = RequestMethod.GET, produces = "application/json")
	public List<Order> getOrderListForCustomer(@PathVariable("custID") String custId) {
		String sqlStatus = "Sql Success!";
		List<Order> orders = null;
		try {
			orders = orderRepository.getOrderListForCustomer(custId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		System.out.println("OrderList" +orders);
		return orders;
	}

	@RequestMapping(value = "/getOrderListForRestaurant/{restaurantId}", method = RequestMethod.GET, produces = "application/json")
	public List<Order> getOrderListForRestaurant(@PathVariable("restaurantId") String restaurantId) {
		String sqlStatus = "Sql Success!";
		List<Order> orders = null;
		try {
			orders = orderRepository.getOrderListForRestaurant(restaurantId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return orders;
	}

	@RequestMapping(value = "/getOrderbyOrderNumForCustomer/{custId}/{orderNo}", method = RequestMethod.GET, produces = "application/json")
	public Order getOrderbyOrderNumForCustomer(@PathVariable("custId") String custId, @PathVariable("orderNo") String orderNum
			) {
		String sqlStatus = "Sql Success!";
		Order order = null;
		try {
			order = orderRepository.getOrderbyOrderNumForCustomer(custId, orderNum);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return order;
	}

	@RequestMapping(value = "/getOrderbyOrderNumForRestaurant/{orderNo}/{restId}", method = RequestMethod.GET, produces = "application/json")
	public Order getOrderbyOrderNumForRestaurant(@PathVariable("orderNo") String orderNum,
			@PathVariable("restId") String restId) {
		String sqlStatus = "Sql Success!";
		Order order = null;
		try {
			order = orderRepository.getOrderbyOrderNumForRestaurant(orderNum, restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return order;
	}
	
	@RequestMapping(value = "/getNewOrderIdToInsert", method = RequestMethod.GET, produces = "application/json")
	public String getNewOrderIdToInsert() {
		
		String sqlStatus = "Sql Success!";
		String orderId="";
		try {
			orderId = orderRepository.getNewOrderIdToInsert();
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return orderId;
	}
	
	@RequestMapping(value = "/deleteOrderForRestaurant/{restaurantId}/{orderNo}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteOrderForRestaurant(@PathVariable("restaurantId") String restaurant, @PathVariable("orderNo") String orderNum) {
		String sqlStatus = "Sql Success!";
		try {
			orderRepository.deleteOrderForRestaurant(restaurant, orderNum);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return new ResponseEntity<String>(sqlStatus, HttpStatus.OK);
	}

}
