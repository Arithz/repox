package com.software.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.DAO.CategoryDAO;
import com.software.DAO.CategoryDAOImpl;
import com.software.api.Category;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO CategoryDAO = new CategoryDAOImpl();
	
	//register new category function
	@RequestMapping(value = "/saveCat", method = RequestMethod.POST)
	public String categoryRegister(@ModelAttribute("category") Category category) {
		CategoryDAO.saveCat(category);
		return "redirect:/softwareregister";
	}
}
