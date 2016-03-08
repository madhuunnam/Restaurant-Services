package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Admin;
import com.restaurant.services.model.Associate;
import com.restaurant.services.model.Customer;

@Component
public class AssociateRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	private static final String UPDATE_ASSOC_RECORDS = "UPDATE Associates SET leaveDate=:leaveDate,firstName=:firstName,"
			+ "middleName=:middleName,lastName=:lastName,nickName=:nickName,telephoneNumber=:phone1,otherPhone=:phone2,"
			+ "addrStNum=:stAddress,city=:city,state=:state,zip=:zip,password=:pwd,"
			+ "bankName=:bankName,bankRouteNum=:bankRouteNo,bankAccNum=:bankAcctNo,comType=:comType,preTye=:preTye,"
			+ "chgDate=:chgDate,uplineID=:uplineId,uplineName=:uplineName,gparID=:gparId,gparName=:gparName,"
			+ "ggparID=:ggparID,ggparName=:ggparName,promoCode=:promoCode,adChannel=:adChannel where assocID = :assocId";

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
	
	public void updateAssociate(Associate associate) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("assocId", associate.getAssocID());
		paramMap.put("leaveDate", associate.getLeaveDate());
		paramMap.put("firstName", associate.getFirstName());
		paramMap.put("middleName", associate.getMiddleName());
		paramMap.put("lastName", associate.getLastName());
		paramMap.put("nickName", associate.getNickName());
		paramMap.put("phone1", associate.getPhone());
		paramMap.put("phone2", associate.getOtherPhone());
		
		paramMap.put("stAddress", associate.getStAddress());
		paramMap.put("city", associate.getCity());
		paramMap.put("state", associate.getState());
		paramMap.put("zip", associate.getZip());
		paramMap.put("pwd", associate.getPassword());
		
		paramMap.put("bankName", associate.getBankName());
		paramMap.put("bankRouteNo", associate.getBankRouteNum());
		paramMap.put("bankAcctNo", associate.getBankAccNum());
		paramMap.put("comType", associate.getComType());
		paramMap.put("preTye", associate.getPreTye());
		paramMap.put("chgDate", associate.getChgDate());
		paramMap.put("uplineId", associate.getUplineID());
		paramMap.put("uplineName", associate.getUplineName());
		paramMap.put("gparId", associate.getGparID());
		paramMap.put("gparName", associate.getGparName());
		paramMap.put("ggparID", associate.getGgparID());
		paramMap.put("ggparName", associate.getGgparName());
		
		paramMap.put("promoCode", associate.getPromoCode());
		paramMap.put("adChannel", associate.getAdChannel());
		
		

		namedParameterTemplate.update(UPDATE_ASSOC_RECORDS, paramMap);
	}
	
	public Associate getAssociate(String assocEmail) {  
		   String SQL = "SELECT * FROM Associates where emailAddress = :email ";
		   
		   SqlParameterSource namedParameters = new MapSqlParameterSource("email", assocEmail);
			
		   Associate assoc = (Associate) namedParameterTemplate.queryForObject(SQL, namedParameters, new AssociateMapper());  
		     return assoc;  
		}
}
