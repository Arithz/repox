package com.software.DAO;

import com.software.api.User;

public interface UserDAO {
	public int saveUser(User user);
	public int saveUserCategory(User user, String value);
	
	User getUserByID(int id);
	public User loginUser(User user);
	
}
