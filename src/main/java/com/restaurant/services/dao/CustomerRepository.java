package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Admin;
import com.restaurant.services.model.Customer;
import com.restaurant.services.model.Restaurant;

@Component
public class CustomerRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_CUSTOMER_RECORDS = "INSERT INTO Customers(firstName, middleName, lastName, emailAddress, password, promoCode, adChannel, insertDate, "
			+ "telephoneNumber, addrStNum, city, state, zip) "
			+ "VALUES (:firstName,:middleName,:lastName,:email,:password,:promoCode,:adChannel,:insertDate,"
			+ ":phone1,:addrStNum,:city,:state,:zip)";

	private static final String UPDATE_CUSTOMER_RECORDS = "UPDATE Customers SET cancelDate=:cancelDate,firstName=:firstName,middleName=:middleName,"
			+ "lastName=:lastName,nickName=:nickName,telephoneNumber=:phone1,otherPhone=:phone2,addrStNum=:addrStNum,city=:city,state=:state,"
			+ "zip=:zip,latitude=:latitude,longitude=:longitude,email=:email,password=:password,cardNumber=:cardNo,cardType=:cardType,cardName=:cardName,"
			+ "cardExp=:cardExp,cardCode=:cardCode,billZip=:billZip,billAddr=:billAddr,cardNumber1=:cardNo1,cardType1=:cardType1,cardName1=cardName1,"
			+ "cardExp1=:cardExp1,cardCode1=:cardCode1,billZip1=:billZip1,billAddr1=:billAddr1,paypalNum=:paypalNo,recomenderID=:recomenderId,"
			+ "recomType=:recomType,promoCode=:promoCode,adChannel=:adChannel where custID=:custId";

	public void registerCustomer(Customer customer) {

		Map<String, Object> paramMap = createParameterMap(customer);
		
		namedParameterTemplate.update(INSERT_CUSTOMER_RECORDS, paramMap);
	}

	public void updateCustomer(Customer customer) {

		Map<String, Object> paramMap = createParameterMap(customer);

		namedParameterTemplate.update(UPDATE_CUSTOMER_RECORDS, paramMap);
	}

	public Customer getCustomer(String custEmail) {

		String SQL = "SELECT * FROM Customers where emailAddress = :email";
		System.out.println("The CUST ID is " + custEmail);
		SqlParameterSource namedParameters = new MapSqlParameterSource("email", custEmail);

		Customer customer = new Customer();
		try {
			customer = (Customer) namedParameterTemplate.queryForObject(SQL, namedParameters, new CustomerMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}

		return customer;
	}
	
	public String getNewCustomerId() {

		String SQL = "SELECT max(custID) as custID FROM Customers ";

		String custId = namedParameterTemplate.getJdbcOperations().queryForObject(SQL, String.class);

		return custId;
	}

	private Map<String, Object> createParameterMap(Customer customer) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custId", customer.getCustID());
		paramMap.put("insertDate", customer.getInsertDate());
		paramMap.put("cancelDate", customer.getCancelDate());
		paramMap.put("firstName", customer.getFirstName());
		paramMap.put("middleName", customer.getMiddleName());
		paramMap.put("lastName", customer.getLastName());
		paramMap.put("nickName", customer.getNickName());
		paramMap.put("phone1", customer.getPhone());
		paramMap.put("phone2", customer.getOtherPhone());

		paramMap.put("addrStNum", customer.getStAddress());
		paramMap.put("city", customer.getCity());
		paramMap.put("state", customer.getState());
		paramMap.put("zip", customer.getZip());
		paramMap.put("latitude", customer.getLatitude());
		paramMap.put("longitude", customer.getLongitude());
		paramMap.put("email", customer.getEmail());
		paramMap.put("password", customer.getPassword());

		paramMap.put("cardNo", customer.getCardNumber());
		paramMap.put("cardType", customer.getCardType());
		paramMap.put("cardName", customer.getCardName());
		paramMap.put("cardExp", customer.getCardExp());
		paramMap.put("cardCode", customer.getCardCode());
		paramMap.put("billZip", customer.getBillZip());
		paramMap.put("billAddr", customer.getBillAddr());

		paramMap.put("cardNo1", customer.getCardNumber1());
		paramMap.put("cardType1", customer.getCardType1());
		paramMap.put("cardName1", customer.getCardName1());
		paramMap.put("cardExp1", customer.getCardExp1());
		paramMap.put("cardCode1", customer.getCardCode1());
		paramMap.put("billZip1", customer.getBillZip1());
		paramMap.put("billAddr1", customer.getBillAddr1());
		paramMap.put("paypalNo", customer.getPaypalNum());

		paramMap.put("recomenderId", customer.getRecomenderID());
		paramMap.put("recomType", customer.getRecomType());
		paramMap.put("promoCode", customer.getPromoCode());
		paramMap.put("adChannel", customer.getAdChannel());
		return paramMap;
	}
}
