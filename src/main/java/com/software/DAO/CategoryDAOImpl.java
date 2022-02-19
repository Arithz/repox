package com.software.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.software.api.Category;
import com.software.config.MainAppConfig;
import com.software.rowmapper.CategoryRowMapper;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	MainAppConfig mac = new MainAppConfig();

	@Autowired
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(mac.dataSource());
	
	@Override
	public int saveCat(Category category) {
		String sql = "INSERT INTO category (categoryName) values ('"+category.getCategoryName()+"')";
		return jdbcTemplate.update(sql);
	}
	
	@Override
	public Category getCategory(int id) {
		Category category  = (Category) jdbcTemplate.queryForObject("SELECT * from category where categoryID = ?",
				new Object[] { id }, new CategoryRowMapper());
		return category;
	}

	@Override
	public List<Category> loadCategory() {
		List<Category> listcategory = new ArrayList<Category>();
		String sql = "SELECT * from category";
		listcategory = jdbcTemplate.query(sql, new CategoryRowMapper());
		return listcategory;
	}
	
	
}
