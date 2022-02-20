package com.software.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.software.api.Software;
import com.software.config.MainAppConfig;
import com.software.rowmapper.SoftwareRowMapper;

@Repository
public class SoftwareDAOImpl implements SoftwareDAO {

	MainAppConfig mac = new MainAppConfig();

	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mac.dataSource());

	@Override
	public int saveSoftware(Software software, String file) {

		String sql = "INSERT INTO software (swName, swVersion, swDescription, categoryID, swFile) values ('"
				+ software.getSwName() + "','" + software.getSwVersion() + "','" + software.getSwDescription() + "','"
				+ software.getCategoryID() + "','" + file + "')";
		System.out.println(sql);
		return jdbcTemplate.update(sql);
	}

	// get all softwares
	@Override
	public List<Software> loadSoftwares() {
		String sql = "SELECT * from software s join category c on s.categoryID=c.categoryID";

		try {
			List<Software> softwares = jdbcTemplate.query(sql, new SoftwareRowMapper());

			return softwares;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int addHistory(int swid, int id) {
		String sql = "SELECT userID from software_action where userID = '" + id + "'";

		List<String> strList = jdbcTemplate.query(sql, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

		if (strList.size() > 0)
			return 0;

		sql = "INSERT INTO software_action values ('" + id + "','" + swid + "')";
		return jdbcTemplate.update(sql);
	}

	// get sw
	@Override
	public Software getSoftwareById(int swID) {
		Software software = (Software) jdbcTemplate.queryForObject("select * from software where swID = ?",
				new Object[] { swID }, new SoftwareRowMapper());
		return software;
	}

	// update sw
	@Override
	public int update(Software software) {
		String sql = "UPDATE software SET swName=?, swVersion=?, swDescription=? where swID = ?";
		return jdbcTemplate.update(sql, software.getSwName(), software.getSwVersion(), software.getSwDescription(), software.getSwID());
	}

	// delete sw
	@Override
	public int delete(Software software) {
		String sql = "DELETE from software where swID =" + software.getSwID();
		return jdbcTemplate.update(sql);
	}

	// check sw to delete
	@Override
	public List<Software> checkSwAvailabletoDelete(int swID) {
		List<Software> softwares = new ArrayList<Software>();
		try {
			Software software = (Software) jdbcTemplate.queryForObject("select * from software s right join software_action sa on s.swID = sa.swID where s.swID = ?",
					new Object[] { swID }, new SoftwareRowMapper());
			softwares.add(software);
			return softwares;
		} catch (Exception e) {
			Software software = new Software();
			softwares.add(software);
			return softwares;
		}
	}
	
	public List<Object> getSoftwareHistory() {
		String sql = "select user.userName, user.userCategory, software.swName, software.swVersion from software_action left join user on user.userID = software_action.userID left join software on software.swID=software_action.swID";
				
		List<Object> strList = jdbcTemplate.query(sql, new RowMapper<Object>() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				List<Object> listData = Arrays.asList(new Object[]{rs.getString(3), rs.getDouble(4), rs.getString(1), rs.getString(2)});
				return listData;
			}
		});
		return strList;
	}
}