package com.software.DAO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.RequestSoftware;

@Repository
public class RequestDAOImpl implements RequestDAO {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveRequest(RequestSoftware req, String userID) {
		String sql = "INSERT INTO software_request(reqswName, reqswVersion, reqDate, reqStatus, userID) values ('"+req.getReqswName()+"','"+req.getReqswVersion()+"','"+req.getReqDate()+"','Pending','"+Integer.parseInt(userID)+"')";;
		System.out.println(sql);
		return jdbcTemplate.update(sql);
//		return 0;
	}

}
