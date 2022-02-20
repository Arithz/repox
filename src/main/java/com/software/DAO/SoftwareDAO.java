package com.software.DAO;

import java.util.List;

import com.software.api.Software;

public interface SoftwareDAO {
	public int saveSoftware(Software software, String file);
	public int addHistory(int swid, int id);
	Software getSoftwareById(int swID);
	public int update(Software software);
	public int delete(Software software);
	List<Software> loadSoftwares();
	List<Software> checkSwAvailabletoDelete(int swID);
	public List<Object> getSoftwareHistory();
}
