package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUserID(rs.getInt("userID"));
		user.setUserName(rs.getString("userName"));
		user.setUserEmail(rs.getString("userEmail"));
		user.setUserPassword(rs.getString("userPassword"));
		user.setUserCategory(rs.getString("userCategory"));
	
		return user;
	}
}