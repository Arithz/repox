package com.software.DAO;

import com.software.api.User;

public interface UserDAO {
	public int saveUser(User user);
	public int saveUserCategory(User user, String value);
	
	public User loginUser(User user);
	
}
