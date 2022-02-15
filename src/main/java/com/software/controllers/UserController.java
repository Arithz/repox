package com.software.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.DAO.UserDAO;
import com.software.DAO.UserDAOImpl;
import com.software.api.User;


@Controller
public class UserController {
	
	@Autowired
	private UserDAO UserDAO = new UserDAOImpl();

	//insert new book function
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String booksave(@ModelAttribute("user") User user) {
		UserDAO.saveUser(user);
		return "redirect:/index";// will redirect to show book list
	}
}
