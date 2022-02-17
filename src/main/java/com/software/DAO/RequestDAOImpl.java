package com.software.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.RequestSoftware;
import com.software.rowmapper.RequestRowMapper;

@Repository
public class RequestDAOImpl implements RequestDAO {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveRequest(RequestSoftware req, String userID) {
		String sql = "INSERT INTO software_request(reqswName, reqswVersion, reqDate, reqStatus, userID) values ('"+req.getReqswName()+"','"+req.getReqswVersion()+"','"+req.getReqDate()+"','Pending','"+Integer.parseInt(userID)+"')";;
		System.out.println(sql);
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<RequestSoftware> loadRequests(String userID) {
		String sql = "SELECT * from software_request WHERE userID = '"+Integer.parseInt(userID)+"'";
		List<RequestSoftware> listrequests = jdbcTemplate.query(sql, new RequestRowMapper());
		return listrequests;
	}

}
