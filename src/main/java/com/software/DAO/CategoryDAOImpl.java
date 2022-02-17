package com.software.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.software.api.Category;
import com.software.rowmapper.CategoryRowMapper;

public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Category getCategory(int id) {
		Category category  = (Category) jdbcTemplate.queryForObject("SELECT categoryName from category where categoryID = ?",
				new Object[] { id }, new CategoryRowMapper());
		return category;
	}

}
