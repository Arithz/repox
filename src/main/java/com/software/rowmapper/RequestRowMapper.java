package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.RequestSoftware;

public class RequestRowMapper implements RowMapper<RequestSoftware> {
	public RequestSoftware mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RequestSoftware req = new RequestSoftware();
		
		req.setReqID(rs.getInt("reqID"));
		req.setReqStatus(rs.getString("reqStatus"));
		req.setReqDate(rs.getDate("reqDate"));
		req.setReqswName(rs.getString("reqswName"));
		req.setReqswVersion(rs.getDouble("reqswVersion"));
		req.setUserID(rs.getInt("userID"));
		req.setAdminID(rs.getInt("admnID"));
		
		return req;
	}
}