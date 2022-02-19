package com.software.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.Admin;
import com.software.rowmapper.AdminRowMapper;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveAdmin(Admin admin) {
		String sql = "INSERT INTO admin (adminID, adminName, adminPassword, adminEmail) values ('"+admin.getAdminID()+"','"+admin.getAdminName()+"','"+admin.getAdminPassword()+"','"+admin.getAdminEmail()+"')";
		return jdbcTemplate.update(sql);
	}
	

	@Override
	public Admin loginAdmin(Admin admin) {
		String sql = "SELECT * FROM admin WHERE adminID ='"+admin.getAdminID()+"' AND adminPassword='"+admin.getAdminPassword()+"'";
		List<Admin> admincheck = jdbcTemplate.query(sql, new AdminRowMapper());
		
		System.out.println(admincheck.size());
		if(admincheck.size() == 1) {
			System.out.println(admin);
			return admin;
		}else {
			return null;
		}
		
	}


	@Override
	public Admin getAdminByID(int id) {
		String sql = "Select * from admin where adminID = '"+id+"'";
		Admin admin = jdbcTemplate.queryForObject(sql, new AdminRowMapper());
		return admin;
	}
	
}
