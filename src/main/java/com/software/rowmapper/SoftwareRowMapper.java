package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.Software;

public class SoftwareRowMapper implements RowMapper<Software> {
	public Software mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Software sw = new Software();
		
		sw.setSwID(rs.getInt("swID"));
		sw.setSwName(rs.getString("swName"));
		sw.setSwVersion(rs.getDouble("swVersion"));
		sw.setSwDescription(rs.getString("swDescription"));
		sw.setSwFile(rs.getBytes("swFile"));
		sw.setCategoryID(rs.getInt("categoryID"));
	
		return sw;
	}
}
