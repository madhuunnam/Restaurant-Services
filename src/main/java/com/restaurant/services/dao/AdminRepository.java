package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Admin;
import com.restaurant.services.model.Customer;

@Component
public class AdminRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String UPDATE_ADMIN_RECORDS = "UPDATE Admins SET firstName=:firstName, middleName=:middleName, lastName=:lastName, telephoneNumber=:phone1, "
			+ "otherPhone=:phone2, mailAddr=:address, password=:password, question=:question, answer=:answer"
			+ " where adminID = :adminId";

	private static final String INSERT_ADMIN_RECORDS = "INSERT INTO Admins(firstName, middleName, lastName, emailAddress, password, telephoneNumber, otherPhone, mailAddr, question, answer, insertDate)"
			+ "VALUES (:firstName,:middleName,:lastName,:email,:password,:phone1,:phone2,:address,:question,:answer,:insertDate)";

	public void registerAdmin(Admin admin) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
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

	public void updateAdmin(Admin admin) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("adminId", admin.getAdminId());
		paramMap.put("firstName", admin.getFirstName());
		paramMap.put("middleName", admin.getMiddleName());
		paramMap.put("lastName", admin.getLastName());
		paramMap.put("password", admin.getPassword());
		paramMap.put("phone1", admin.getPhone());
		paramMap.put("phone2", admin.getOtherPhone());
		paramMap.put("address", admin.getAddress());
		paramMap.put("question", admin.getSecQuest());
		paramMap.put("answer", admin.getSecAns());

		namedParameterTemplate.update(UPDATE_ADMIN_RECORDS, paramMap);
	}

	public Admin getAdmin(String adminEmail) {

		String SQL = "SELECT * FROM Admins where emailAddress = :email ";
		SqlParameterSource namedParameters = new MapSqlParameterSource("email", adminEmail);
		Admin admin = (Admin) namedParameterTemplate.queryForObject(SQL, namedParameters, new AdminMapper());

		return admin;
	}

}
