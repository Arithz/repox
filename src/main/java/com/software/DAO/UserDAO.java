package com.software.DAO;

import com.software.api.User;

public interface UserDAO {
	public int saveUser(User user); 
	public User getLastUser();
	public User getUserById(int id);
}
