package com.software.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.DAO.AdminDAO;
import com.software.DAO.AdminDAOImpl;
import com.software.api.Admin;

@Controller
public class AdminController {
	@Autowired
	private AdminDAO AdminDAO = new AdminDAOImpl();

	//register new admin function
	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
	public String adminRegister(@ModelAttribute("admin") Admin admin, HttpSession session) {
		AdminDAO.saveAdmin(admin);
		return "redirect:/index";
	}
	
	//login admin function
	
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute("admin") Admin admin, HttpSession session) {
		Admin loginedadmin = AdminDAO.loginAdmin(admin);
		System.out.println(loginedadmin);
		if(loginedadmin != null) {
			session.setAttribute("adminID",loginedadmin.getAdminID());
			return "redirect:/softwareregister";
		}else {
			return "redirect:/loginAdmin";
		}
		
	}
}
