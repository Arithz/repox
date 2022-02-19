package com.software.DAO;

import java.util.List;

import com.software.api.Category;

public interface CategoryDAO {
	public int saveCat(Category category);
	public Category getCategory(int id);
	List<Category> loadCategory();
}
