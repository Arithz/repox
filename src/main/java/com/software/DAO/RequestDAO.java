package com.software.DAO;

import com.software.api.RequestSoftware;

public interface RequestDAO {
	public int saveRequest(RequestSoftware req, String userID);
}
