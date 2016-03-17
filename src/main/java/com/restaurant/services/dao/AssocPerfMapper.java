package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.AssocPerf;

public class AssocPerfMapper implements RowMapper {

	public AssocPerf mapRow(ResultSet rs, int rowNum) throws SQLException {

		AssocPerf ap = new AssocPerf();

		ap.setAssocID(rs.getString("assocID"));
		ap.setRunStart(rs.getDate("runStart"));
		ap.setAssocTitle(rs.getString("assocTitle"));
		ap.setTitleDate(rs.getDate("titleDate"));
		ap.setDownIDs(rs.getString("downIDs"));
		ap.setNumCust(rs.getInt("numCust"));
		ap.setNumRes(rs.getInt("numRes"));
		ap.setPersonScore(rs.getInt("personScore"));
		ap.setTeamScore(rs.getInt("teamScore"));

		return ap;
	}
}
