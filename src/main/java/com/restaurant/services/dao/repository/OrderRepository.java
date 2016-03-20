package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.OrderMapper;
import com.restaurant.services.model.Order;

@Component
public class OrderRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_ORDER_RECORDS = "INSERT INTO Orders(resID, orderNum, custId, custName, resName, orderType, orderTime, numberOfLines, "
			+ "itemName, subTot, discountPercentage, taxRatePercent, taxAmount, tip, deliFee, totPrice, receiverName, deliAddr, status, msgToCust, msgToRes, "
			+ "nonSmoke, resTable, resPeople, resTime, pickTime, arriveTime, agentName, notes) VALUES (:restId,:orderNo,:custId,:custName,:restName,"
			+ ":orderType,:orderTime,:numberOfLines,:itemName,:subTot,:discountPercentage,:taxRatePercent,:taxAmount,:tip,:deliFee,:totPrice,:receiverName,:deliAddr,"
			+ ":status,:msgToCust,:msgToRes,:nonSmoke,:resTable,:resPeople,:resTime,:pickTime,:arriveTime,:agentName,:notes)";

	private static final String UPDATE_ORDER_RECORDS = "UPDATE Orders SET orderType=:orderType,orderTime=:orderTime,numberOfLines=:numberOfLines,itemName=:itemName,"
			+ "subTot=:subTot,discountPercentage=:discountPercentage,taxRatePercent=:taxRatePercent,taxAmount=:taxAmount,tip=:tip,deliFee=:deliFee,"
			+ "totPrice=:totPrice,receiverName=:receiverName,deliAddr=:deliAddr,status=:status,msgToCust=:msgToCust,msgToRes=:msgToRes,nonSmoke=:nonSmoke,"
			+ "resTable=:resTable,resPeople=:resPeople,resTime=:resTime,pickTime=:pickTime,arriveTime=:arriveTime,agentName=:agentName,notes=:notes WHERE resID = :restId"
			+ "and orderNum = :orderNo";

	public void addOrder(Order order) {

		Map<String, Object> paramMap = createParameterMap(order);

		namedParameterTemplate.update(INSERT_ORDER_RECORDS, paramMap);
	}

	public void updateOrder(Order order) {

		Map<String, Object> paramMap = createParameterMap(order);

		namedParameterTemplate.update(UPDATE_ORDER_RECORDS, paramMap);
	}

	public List<Order> getOrderListForCustomer(String custId) {
		String SQL = "SELECT * FROM Orders where custId = :custID";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custID", custId);
		List<Order> ordersOfCustomer = (List<Order>) namedParameterTemplate.query(SQL, paramMap, new OrderMapper());
		return ordersOfCustomer;
	}

	public List<Order> getOrderListForRestaurant(String restId) {
		String SQL = "SELECT * FROM Orders where resID = :restId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		List<Order> ordersOfRestaurant = (List<Order>) namedParameterTemplate.query(SQL, paramMap, new OrderMapper());
		return ordersOfRestaurant;
	}

	public Order getOrderbyOrderNumForCustomer(String orderNo, String custId) {
		String SQL = "SELECT * FROM Orders where orderNum = :orderNum and custId = :custId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderNum", orderNo);
		paramMap.put("custId", custId);
		Order order = (Order) namedParameterTemplate.query(SQL, paramMap, new OrderMapper());
		return order;
	}

	public Order getOrderbyOrderNumForRestaurant(String orderNo, String restId) {
		String SQL = "SELECT * FROM Orders where orderNum = :orderNum";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderNum", orderNo);
		paramMap.put("resID", restId);
		Order order = (Order) namedParameterTemplate.query(SQL, paramMap, new OrderMapper());
		return order;
	}

	private Map<String, Object> createParameterMap(Order order) {

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
