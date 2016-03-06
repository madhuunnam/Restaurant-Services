package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Associate;

@Component
public class AssociateRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	
	private static final String INSERT_ASSOC_RECORDS = 
			"INSERT INTO Associates(firstName, middleName, lastName, emailAddress, password, promoCode, adChannel, joinDate, "
			+ "telephoneNumber, addrStNum, city, state, zip	) "
			+ "VALUES (:firstName,:middleName,:lastName,:email,:password,:promoCode,:adChannel,:insertDate,"
			+ ":phone,:stAddress,:city,:state,:zip)";
	
	public void registerAssociate(Associate associate){
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("firstName", associate.getFirstName());
		paramMap.put("middleName", associate.getMiddleName());
		paramMap.put("lastName", associate.getLastName());
		paramMap.put("email", associate.getEmail());
		paramMap.put("password", associate.getPassword());
		paramMap.put("promoCode", associate.getPromoCode());
		paramMap.put("adChannel", associate.getAdChannel());
		paramMap.put("insertDate", associate.getInsertDate());
		paramMap.put("phone", associate.getPhone());
		paramMap.put("stAddress", associate.getStAddress());
		paramMap.put("city", associate.getCity());
		paramMap.put("state", associate.getState());
		paramMap.put("zip", associate.getZip());
		
		namedParameterTemplate.update(INSERT_ASSOC_RECORDS, paramMap);
	}

}
