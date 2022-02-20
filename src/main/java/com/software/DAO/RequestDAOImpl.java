package com.software.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.RequestSoftware;
import com.software.api.User;
import com.software.config.MainAppConfig;
import com.software.rowmapper.RequestRowMapper;
import com.software.rowmapper.UserRowMapper;

@Repository
public class RequestDAOImpl implements RequestDAO {
		
	MainAppConfig mac = new MainAppConfig();
	
	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mac.dataSource());

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
	
	@Override
	public List<RequestSoftware> loadAllRequests() {
		String sql = "SELECT * from software_request";
		List<RequestSoftware> listrequests = jdbcTemplate.query(sql, new RequestRowMapper());
		return listrequests;
	}

	@Override
	public List<RequestSoftware> loadAdminRequests() {
		String sql = "SELECT * from software_request where reqStatus = 'Pending'";
		List<RequestSoftware> listrequests = jdbcTemplate.query(sql, new RequestRowMapper());
		return listrequests;
	}

	@Override
	public RequestSoftware getRequestByID(int id) {
		String sql = "SELECT * from software_request WHERE reqID = '"+id+"'";
		RequestSoftware req = jdbcTemplate.queryForObject(sql, new RequestRowMapper());
		return req;
	}

	@Override
	public int acceptRequest(int id, int adminID) {
		String sql = "UPDATE software_request SET reqStatus = 'Accepted', adminID = ? where reqID = ?";
		return jdbcTemplate.update(sql, adminID, id);
	}

	@Override
	public int rejectRequest(int id) {
		String sql = "UPDATE software_request SET reqStatus = 'Rejected' where reqID = ?";
		return jdbcTemplate.update(sql, id);
	}

}
