package com.software.DAO;

import com.software.api.Admin;

public interface AdminDAO {
	public int saveAdmin(Admin admin);
	
	public Admin loginAdmin(Admin admin);
	
}