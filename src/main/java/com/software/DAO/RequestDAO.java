package com.software.DAO;

import java.util.List;

import com.software.api.RequestSoftware;

public interface RequestDAO {
	public int saveRequest(RequestSoftware req, String userID);
	public RequestSoftware getRequestByID(int id);
	public int acceptRequest(int id);
	public int rejectRequest(int id);
	List<RequestSoftware> loadRequests(String userID);
	List<RequestSoftware> loadAdminRequests();
}
