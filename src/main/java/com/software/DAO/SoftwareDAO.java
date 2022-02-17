package com.software.DAO;

import java.util.List;

import com.software.api.Software;

public interface SoftwareDAO {
	public int saveSoftware(Software software);
	
	List<Software> loadSoftwares();
	
}
