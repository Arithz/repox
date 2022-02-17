package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.Admin;

public class AdminRowMapper implements RowMapper<Admin> {
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Admin admin = new Admin();
		
		admin.setAdminID(rs.getInt("adminid"));
		admin.setAdminName(rs.getString("adminname"));
		admin.setAdminEmail(rs.getString("adminemail"));
		admin.setAdminPassword(rs.getString("adminpassword"));
		
		return admin;
	}
}