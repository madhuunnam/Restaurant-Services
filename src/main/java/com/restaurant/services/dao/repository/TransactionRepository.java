package com.restaurant.services.dao.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.TransactionMapper;
import com.restaurant.services.model.Transaction;

@Component
public class TransactionRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_TRANSACTION_RECORDS = "INSERT INTO Transactions(resID, orderNum, custId, custName, resName, orderType, orderTime, numberOfLines, "
			+ "itemName, subTot, discountPercentage, taxRatePercent, taxAmount, tip, deliFee, totPrice, receiverName, deliAddr, status, msgToCust, msgToRes, "
			+ "nonSmoke, resTable, resPeople, resTime, pickTime, arriveTime, agentName, notes) VALUES (:restId,:orderNo,:custId,:custName,:restName,"
			+ ":orderType,:orderTime,:numberOfLines,:itemName,:subTot,:discountPercentage,:taxRatePercent,:taxAmount,:tip,:deliFee,:totPrice,:receiverName,:deliAddr,"
			+ ":status,:msgToCust,:msgToRes,:nonSmoke,:resTable,:resPeople,:resTime,:pickTime,:arriveTime,:agentName,:notes)";

	private static final String PICKUP_TRANSACTIONS_SUM = "SELECT ROUND(sum(totPrice),2) from Transactions where orderType = 'PickUp' and resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String PICKUP_TRANSACTIONS_COUNT = "SELECT count(*) from Transactions where orderType = 'PickUp' and resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String DELIVERY_TRANSACTIONS_SUM = "SELECT ROUND(sum(totPrice),2) from Transactions where orderType = 'Delivery' and resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String DELIVERY_TRANSACTIONS_COUNT = "SELECT count(*) from Transactions where orderType = 'Delivery' and resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String RESERVATION_TRANSACTIONS_SUM = "SELECT ROUND(sum(totPrice),2) from Transactions where orderType = 'Reservation' and resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String RESERVATION_TRANSACTIONS_COUNT = "SELECT count(*) from Transactions where orderType = 'Reservation' and resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String TOTAL_TRANSACTIONS_SUM = "SELECT ROUND(sum(totPrice),2) from Transactions where resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	private static final String TOTAL_TRANSACTIONS_COUNT = "SELECT count(*) from Transactions where resID=:restId and orderTime BETWEEN :fromDate AND :toDate";
	
	

	public void addTransaction(Transaction order) {

		Map<String, Object> paramMap = createParameterMap(order);

		namedParameterTemplate.update(INSERT_TRANSACTION_RECORDS, paramMap);

	}
	
	public String getPickUpOrdersTotalPrice(String restId, String toDate, String fromDate) {
		
		String pickUpSum = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			 
			pickUpSum = namedParameterTemplate.queryForObject(PICKUP_TRANSACTIONS_SUM, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return pickUpSum;
	}
	public String getNumberOfPickUpOrders(String restId, String toDate, String fromDate) {

		String noOfpickUpOrders = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			noOfpickUpOrders = namedParameterTemplate.queryForObject(PICKUP_TRANSACTIONS_COUNT, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return noOfpickUpOrders;
	}
	
	public String getDeliveryOrdersTotalPrice(String restId, String toDate, String fromDate) {

		String deliverySum = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			 
			deliverySum = namedParameterTemplate.queryForObject(DELIVERY_TRANSACTIONS_SUM, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return deliverySum;
	}
	public String getNumberOfDeliveryOrders(String restId, String toDate, String fromDate) {

		String noOfdeliveryOrders = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			noOfdeliveryOrders = namedParameterTemplate.queryForObject(DELIVERY_TRANSACTIONS_COUNT, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return noOfdeliveryOrders;
	}
	
	public String getReservationOrdersTotalPrice(String restId, String toDate, String fromDate) {

		String reservationSum = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			 
			reservationSum = namedParameterTemplate.queryForObject(RESERVATION_TRANSACTIONS_SUM, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return reservationSum;
	}
	public String getNumberOfReservationOrders(String restId, String toDate, String fromDate) {

		String noOfReservationOrders = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			noOfReservationOrders = namedParameterTemplate.queryForObject(RESERVATION_TRANSACTIONS_COUNT, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return noOfReservationOrders;
	}
	
	public String getOrdersTotalPrice(String restId, String toDate, String fromDate) {

		String totalSum = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			 
			totalSum = namedParameterTemplate.queryForObject(TOTAL_TRANSACTIONS_SUM, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return totalSum;
	}
	public String getNumberOfOrders(String restId, String toDate, String fromDate) {

		String noOfOrders = "";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		try {
			noOfOrders = namedParameterTemplate.queryForObject(TOTAL_TRANSACTIONS_COUNT, paramMap, String.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return noOfOrders;
	}
	
	public List<Transaction> getPickUpOrderList(String restId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM Transactions where resID = :restId and orderType='PickUp' and orderTime BETWEEN :fromDate AND :toDate";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<Transaction> pickUpOrdersOfRestaurant = (List<Transaction>) namedParameterTemplate.query(SQL, paramMap, new TransactionMapper());
		return pickUpOrdersOfRestaurant;
	}
	public List<Transaction> getDeliveryOrderList(String restId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM Transactions where resID = :restId and orderType='Delivery' and orderTime BETWEEN :fromDate AND :toDate";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<Transaction> pickUpOrdersOfRestaurant = (List<Transaction>) namedParameterTemplate.query(SQL, paramMap, new TransactionMapper());
		return pickUpOrdersOfRestaurant;
	}
	public List<Transaction> getReservationOrderList(String restId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM Transactions where resID = :restId and orderType='Reservation' and orderTime BETWEEN :fromDate AND :toDate";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<Transaction> pickUpOrdersOfRestaurant = (List<Transaction>) namedParameterTemplate.query(SQL, paramMap, new TransactionMapper());
		return pickUpOrdersOfRestaurant;
	}
	public List<Transaction> getTotalOrderList(String restId, String toDate, String fromDate) {
		String SQL = "SELECT * FROM Transactions where resID = :restId and orderTime BETWEEN :fromDate AND :toDate";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("toDate", toDate);
		paramMap.put("fromDate", fromDate);
		List<Transaction> pickUpOrdersOfRestaurant = (List<Transaction>) namedParameterTemplate.query(SQL, paramMap, new TransactionMapper());
		return pickUpOrdersOfRestaurant;
	}

	private Map<String, Object> createParameterMap(Transaction order) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", order.getRestId());
		paramMap.put("orderNo", order.getOrderNo());
		paramMap.put("custId", order.getCustId());
		paramMap.put("custName", order.getCustName());
		paramMap.put("restName", order.getResName());
		paramMap.put("orderType", order.getOrderType());
		paramMap.put("orderTime", order.getOrderTime());
		paramMap.put("numberOfLines", order.getNumberOfLines());
		paramMap.put("itemName", order.getItemName());
		paramMap.put("subTot", order.getSubTot());
		paramMap.put("discountPercentage", order.getDiscountPercentage());
		paramMap.put("taxRatePercent", order.getTaxRatePercent());
		paramMap.put("taxAmount", order.getTaxAmount());
		paramMap.put("tip", order.getTip());
		paramMap.put("deliFee", order.getDeliFee());
		paramMap.put("totPrice", order.getTotPrice());
		paramMap.put("receiverName", order.getReceiverName());
		paramMap.put("deliAddr", order.getDeliAddr());
		paramMap.put("status", order.getStatus());
		paramMap.put("msgToCust", order.getMsgToCust());
		paramMap.put("msgToRes", order.getMsgToRes());
		paramMap.put("nonSmoke", order.getNonSmoke());
		paramMap.put("resTable", order.getResTable());
		paramMap.put("resPeople", order.getResPeople());
		paramMap.put("resTime", order.getResTime());
		paramMap.put("pickTime", order.getPickTime());
		paramMap.put("arriveTime", order.getArriveTime());
		paramMap.put("agentName", order.getAgentName());
		paramMap.put("notes", order.getNotes());

		return paramMap;
	}
}
