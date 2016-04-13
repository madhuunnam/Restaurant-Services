package com.restaurant.services.dao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.AdminStatistics;

@Component
public class AdminStatisticsRepository {
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	
	public AdminStatistics getAdminStatistics() {
		
		String noOfCustomersSQL = "SELECT count(*) FROM Customers";
		String noOfRestsSQL = "SELECT count(*) FROM Restaurants";
		String noOfMenusSQL = "SELECT count(*) FROM Items ";
		String noOfTransactionsSQL = "SELECT count(*) FROM Transactions";
		String noOfActiveOrdersSQL = "SELECT count(*) FROM Orders where status != 'Inactive'";
		String noOfTASQL = "SELECT count(*) FROM Customers";
		String noOfASQL = "SELECT count(*) FROM Customers";
		String noOfSASQL = "SELECT count(*) FROM Customers";
		String noOfMDSQL = "SELECT count(*) FROM Customers";
		String noOfSMDSQL = "SELECT count(*) FROM Customers";
		String noOfCEOSQL = "SELECT count(*) FROM Customers";
		String noOfDeliveryOrdersSQL = "SELECT count(*) FROM Transactions where orderType='Delivery'";
		String deliTotalSQL = "SELECT ROUND(sum(totPrice),2) FROM Transactions where orderType='Delivery'";
		String noOfPickUpOrdersSQL = "SELECT count(*) from Transactions where orderType='PickUp'";
		String pickUpTotalSQL = "SELECT ROUND(sum(totPrice),2) FROM Transactions where orderType='PickUp'";
		String noOfReserveOrdersSQL = "SELECT count(*) from Transactions where orderType='Reservation'";
		String ReserveTotalSQL = "SELECT ROUND(sum(totPrice),2) FROM Transactions where orderType='Reservation'";
		String totalOrdersSQL ="SELECT count(*) from Transactions";
		String totalAmtSQL ="SELECT ROUND(sum(totPrice),2) FROM Transactions";
		String totalAssocMembersSQL = "SELECT count(*) from Associates";

		AdminStatistics stats = new AdminStatistics();
		
		stats.setNoOfCustomers(namedParameterTemplate.getJdbcOperations().queryForObject(noOfCustomersSQL, String.class));   
		stats.setNoOfRestaurants(namedParameterTemplate.getJdbcOperations().queryForObject(noOfRestsSQL, String.class));	
		stats.setNoOfMenus(namedParameterTemplate.getJdbcOperations().queryForObject(noOfMenusSQL, String.class));
		stats.setNoOfTransactions(namedParameterTemplate.getJdbcOperations().queryForObject(noOfTransactionsSQL, String.class));
		stats.setNoOfActiveOrders(namedParameterTemplate.getJdbcOperations().queryForObject(noOfActiveOrdersSQL, String.class));
		stats.setNoOfTa(namedParameterTemplate.getJdbcOperations().queryForObject(noOfTASQL, String.class));
		stats.setNoOfAssociates(namedParameterTemplate.getJdbcOperations().queryForObject(noOfASQL, String.class));
		stats.setNoOfSa(namedParameterTemplate.getJdbcOperations().queryForObject(noOfSASQL, String.class));
		stats.setNoOfMd(namedParameterTemplate.getJdbcOperations().queryForObject(noOfMDSQL, String.class));
		stats.setNoOfSmd(namedParameterTemplate.getJdbcOperations().queryForObject(noOfSMDSQL, String.class));
		stats.setNoOfCeo(namedParameterTemplate.getJdbcOperations().queryForObject(noOfCEOSQL, String.class));
		stats.setNoOfDeliveryOrders(namedParameterTemplate.getJdbcOperations().queryForObject(noOfDeliveryOrdersSQL, String.class));
		stats.setTotalDeliAmt(namedParameterTemplate.getJdbcOperations().queryForObject(deliTotalSQL, String.class));
		stats.setNoOfPickUpOrders(namedParameterTemplate.getJdbcOperations().queryForObject(noOfPickUpOrdersSQL, String.class));
		stats.setTotalPickUpAmt(namedParameterTemplate.getJdbcOperations().queryForObject(pickUpTotalSQL, String.class));
		stats.setNoOfReserveOrders(namedParameterTemplate.getJdbcOperations().queryForObject(noOfReserveOrdersSQL, String.class));
		stats.setTotalReserveAmt(namedParameterTemplate.getJdbcOperations().queryForObject(ReserveTotalSQL, String.class));
		stats.setNoOfTotalOrders(namedParameterTemplate.getJdbcOperations().queryForObject(totalOrdersSQL, String.class));
		stats.setTotalOrderAmt(namedParameterTemplate.getJdbcOperations().queryForObject(totalAmtSQL, String.class));
		stats.setNoOfTotAssocMembers(namedParameterTemplate.getJdbcOperations().queryForObject(totalAssocMembersSQL, String.class));
		
		return stats;
	}
}
