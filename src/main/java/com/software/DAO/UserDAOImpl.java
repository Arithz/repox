package com.software.DAO;

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
		System.out.println(sql);
		return jdbcTemplate.update(sql);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getLastUser() {
		User user = (User) jdbcTemplate.queryForObject("SELECT * FROM user ORDER BY userid DESC LIMIT 1;",
				new UserRowMapper());
		return user;
	}

}
