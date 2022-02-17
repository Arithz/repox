package com.software.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.Software;
import com.software.rowmapper.SoftwareRowMapper;

@Repository
public class SoftwareDAOImpl implements SoftwareDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveSoftware(Software software) {
		// TODO Auto-generated method stub
		return 0;
	}

	//get all softwares
	@Override
	public List<Software> loadSoftwares() {
		String sql = "SELECT * from software s join category c on s.categoryID=c.categoryID";
		
        try{
            List<Software> softwares = jdbcTemplate.query(sql, new SoftwareRowMapper());
 
            return softwares;
        } catch(Exception e) {
            e.printStackTrace();
        }
		
		return null;
	}

}
