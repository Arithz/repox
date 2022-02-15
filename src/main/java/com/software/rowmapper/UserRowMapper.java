package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		
		user.setUserID(rs.getInt("userid"));
		user.setUserName(rs.getString("username"));
		user.setUserEmail(rs.getString("useremail"));
		user.setUserPassword(rs.getString("userpassword"));
		user.setUserCategory(rs.getString("usercategory"));
		
		return user;
	}
}