package com.software.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.User;
import com.software.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl implements UserDAO {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveUser(User user) {
		String sql = "INSERT INTO user (userID, userName, userPassword, userEmail, userCategory) values ('"+user.getUserID()+"','"+user.getUserName()+"','"+user.getUserPassword()+"','"+user.getUserEmail()+"','"+user.getUserCategory()+"')";
		return jdbcTemplate.update(sql);
	}
	
	@Override
	public int saveUserCategory(User user, String value) {
		String sql = "";
		if(user.getUserCategory().equals("Lecturer")) {
			sql = "INSERT INTO lecturer values ('"+user.getUserID()+"','"+value+"')";
		}else if(user.getUserCategory().equals("Student")) {
			sql = "INSERT INTO student values ('"+user.getUserID()+"','"+value+"')";
		}
		
		return jdbcTemplate.update(sql);
	}

	@Override
	public User loginUser(User user) {
		String sql = "SELECT * FROM user WHERE userID ='"+user.getUserID()+"' AND userPassword='"+user.getUserPassword()+"' AND userCategory = '"+user.getUserCategory()+"'";
		List<User> usercheck = jdbcTemplate.query(sql, new UserRowMapper());
		
		if(usercheck.size() == 1) {
			return user;
		}else {
			return null;
		}
		
	}

}
