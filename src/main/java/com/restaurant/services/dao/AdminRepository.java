package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Admin;

@Component
public class AdminRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	
	private static final String INSERT_ADMIN_RECORDS = 
			"INSERT INTO Admins(firstName, middleName, lastName, emailAddress, password, telephoneNumber, otherPhone, mailAddr, question, answer, insertDate)"
			+ "VALUES (:firstName,:middleName,:lastName,:email,:password,:phone1,:phone2,:address,:question,:answer,:insertDate)";
	
	public void registerAdmin(Admin admin){
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("firstName", admin.getFirstName());
		paramMap.put("middleName", admin.getMiddleName());
		paramMap.put("lastName", admin.getLastName());
		paramMap.put("email", admin.getEmail());
		paramMap.put("password", admin.getPassword());
		paramMap.put("phone1", admin.getPhone());
		paramMap.put("phone2", admin.getOtherPhone());
		paramMap.put("insertDate", admin.getInsertDate());
		paramMap.put("address", admin.getAddress());
		paramMap.put("question", admin.getSecQuest());
		paramMap.put("answer", admin.getSecAns());
		
		
		namedParameterTemplate.update(INSERT_ADMIN_RECORDS, paramMap);
	}
}
