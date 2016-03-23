package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.AssocPerfMapper;
import com.restaurant.services.model.AssocPerf;

@Component
public class AssocPerfRepository {
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_ASSOCPERF_RECORDS = "INSERT INTO AssocPerf(assocID, runStart, assocTitle, titleDate, downIDs, numCust, "
			+ "numRes, personScore, teamScore) VALUES (:assocId,:runStart,:assocTitle,:titleDate,:downIDs,:numCust,:numRes,:personScore,:teamScore)";

	private static final String UPDATE_ASSOCPERF_RECORDS = "UPDATE AssocPerf SET runStart=:runStart,assocTitle=:assocTitle,titleDate=:titleDate,downIDs=:downIDs,"
			+ "numCust=:numCust,numRes=:numRes,personScore=:personScore,teamScore=:teamScore WHERE assocID=:assocId";

	public void addToAssocPerf(AssocPerf assocPerf, String assocId) {

		Map<String, Object> paramMap = createParameterMap(assocPerf);
		paramMap.put("assocId", assocId);
		namedParameterTemplate.update(INSERT_ASSOCPERF_RECORDS, paramMap);
	}

	public void updateAssocPerf(AssocPerf assocPerf) {

		Map<String, Object> paramMap = createParameterMap(assocPerf);
		paramMap.put("assocId", assocPerf.getAssocID());
		namedParameterTemplate.update(UPDATE_ASSOCPERF_RECORDS, paramMap);
	}

	public AssocPerf getAssocPerf(String assocId) {

		String SQL = "SELECT * FROM AssocPerf WHERE assocID = :assocId ";

		SqlParameterSource namedParameters = new MapSqlParameterSource("assocId", assocId);

		AssocPerf assocPerf = (AssocPerf) namedParameterTemplate.queryForObject(SQL, namedParameters,
				new AssocPerfMapper());

		return assocPerf;
	}

	private Map<String, Object> createParameterMap(AssocPerf assocPerf) {

		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("runStart", assocPerf.getRunStart());
		paramMap.put("assocTitle", assocPerf.getAssocTitle());
		paramMap.put("titleDate", assocPerf.getTitleDate());
		paramMap.put("downIDs", assocPerf.getDownIDs());
		paramMap.put("numCust", assocPerf.getNumCust());
		paramMap.put("numRes", assocPerf.getNumRes());
		paramMap.put("personScore", assocPerf.getPersonScore());
		paramMap.put("teamScore", assocPerf.getTeamScore());

		return paramMap;
	}
}
