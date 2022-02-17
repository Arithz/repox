package com.software.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.software.api.Category;

public class CategoryRowMapper implements RowMapper<Category> {
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Category category = new Category();
		
		category.setCategoryID(rs.getInt("categoryID"));
		category.setCategoryName(rs.getString("categoryName"));
		
		return category;
	}
}