package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.AssociateMapper;
import com.restaurant.services.model.Admin;
import com.restaurant.services.model.Associate;
import com.restaurant.services.model.Customer;

@Component
public class AssociateRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String UPDATE_ASSOC_RECORDS = "UPDATE Associates SET leaveDate=:leaveDate,firstName=:firstName,"
			+ "middleName=:middleName,lastName=:lastName,nickName=:nickName,telephoneNumber=:phone1,otherPhone=:phone2,"
			+ "addrStNum=:stAddress,city=:city,state=:state,zip=:zip,emailAddress=:email,password=:pwd,"
			+ "bankName=:bankName,bankRouteNum=:bankRouteNo,bankAccNum=:bankAcctNo,comType=:comType,preTye=:preTye,"
			+ "chgDate=:chgDate,uplineID=:uplineId,uplineName=:uplineName,gparID=:gparId,gparName=:gparName,"
			+ "ggparID=:ggparID,ggparName=:ggparName,promoCode=:promoCode,adChannel=:adChannel where assocID = :assocId";

	private static final String INSERT_ASSOC_RECORDS = "INSERT INTO Associates(firstName, middleName, lastName, emailAddress, password, promoCode, adChannel, joinDate, "
			+ "telephoneNumber, addrStNum, city, state, zip	) "
			+ "VALUES (:firstName,:middleName,:lastName,:email,:pwd,:promoCode,:adChannel,:insertDate,"
			+ ":phone1,:stAddress,:city,:state,:zip)";

	public void registerAssociate(Associate associate) {

		Map<String, Object> paramMap = createParameterMap(associate);

		namedParameterTemplate.update(INSERT_ASSOC_RECORDS, paramMap);
	}

	public void updateAssociate(Associate associate) {

		Map<String, Object> paramMap = createParameterMap(associate);

		namedParameterTemplate.update(UPDATE_ASSOC_RECORDS, paramMap);
	}

	public Associate getAssociate(String assocEmail) {
		
		String SQL = "SELECT * FROM Associates A, AssocPerf AP where emailAddress = :email and A.assocID = AP.assocID ";

		SqlParameterSource namedParameters = new MapSqlParameterSource("email", assocEmail);

		Associate assoc = (Associate) namedParameterTemplate.queryForObject(SQL, namedParameters,
				new AssociateMapper());
		return assoc;
	}

	public String getNewAssociateId() {

		String SQL = "SELECT max(assocID) as assocId FROM Associates ";

		String assocId = namedParameterTemplate.getJdbcOperations().queryForObject(SQL, String.class);

		return assocId;
	}

	private Map<String, Object> createParameterMap(Associate associate) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("assocId", associate.getAssocID());
		paramMap.put("insertDate", associate.getInsertDate());
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
		paramMap.put("email", associate.getEmail());
		paramMap.put("pwd", associate.getPassword());

		paramMap.put("bankName", associate.getBankName());
		paramMap.put("bankRouteNo", associate.getBankRouteNum());
		paramMap.put("bankAcctNo", associate.getBankAccNum());
		paramMap.put("comType", associate.getComType());
		paramMap.put("preTye", associate.getPreTye());
		paramMap.put("chgDate", associate.getChgDate());
		//paramMap.put("uplineId", associate.getUplineID());
		if(associate.getUplineID() !=null && !associate.getUplineID().isEmpty()){
			paramMap.put("uplineId", Integer.parseInt(associate.getUplineID()));
		}else{
			paramMap.put("uplineId", null);
		}
		paramMap.put("uplineName", associate.getUplineName());
	//	paramMap.put("gparId", associate.getGparID());
		if(associate.getGparID() !=null && !associate.getGparID().isEmpty()){
			paramMap.put("gparId", Integer.parseInt(associate.getGparID()));
		}else{
			paramMap.put("gparId", null);
		}
		paramMap.put("gparName", associate.getGparName());
		//paramMap.put("ggparID", associate.getGgparID());
		if(associate.getGgparID() !=null && !associate.getGgparID().isEmpty()){
			paramMap.put("ggparID", Integer.parseInt(associate.getGgparID()));
		}else{
			paramMap.put("ggparID", null);
		}
		paramMap.put("ggparName", associate.getGgparName());

		paramMap.put("promoCode", associate.getPromoCode());
		paramMap.put("adChannel", associate.getAdChannel());

		return paramMap;
	}
}
