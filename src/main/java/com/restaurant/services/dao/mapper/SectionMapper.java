package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Section;

public class SectionMapper implements RowMapper {

	public Section mapRow(ResultSet rs, int rowNum) throws SQLException {

		Section sec = new Section();
		sec.setRestId(rs.getString("resID"));
		sec.setSecName(rs.getString("secName"));
		sec.setNumItem(rs.getInt("numItem"));

		return sec;

	}
}
