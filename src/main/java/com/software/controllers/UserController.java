package com.software.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.software.DAO.UserDAO;
import com.software.DAO.UserDAOImpl;
import com.software.api.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO UserDAO = new UserDAOImpl();

	//register new user function
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute("user") User user, @RequestParam("lecturernum") String lectnum, @RequestParam("coursecode") String coursecode) {
		int result = UserDAO.saveUser(user);
		
		if (result == 0) return "redirect:/userregister";
		
		if(user.getUserCategory().equals("Lecturer")) {
			UserDAO.saveUserCategory(user, lectnum);
		}else {
			UserDAO.saveUserCategory(user, coursecode);
		}
		
		return "redirect:/index";
	}
	
	//login user function
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("user") User user, HttpSession session) {
		User logineduser = UserDAO.loginUser(user);
		if(logineduser != null) {
			session.setAttribute("userID",logineduser.getUserID());
			return "redirect:/softwareviewer";
		}else {
			return "redirect:/login";
		}
	}
	
	//go to request software page if user is lecturer
	@GetMapping("/requestsoftware")
	public String redirectRequestSoftwarePage(HttpSession session) {
		Object id = session.getAttribute("userID");
		Boolean result = UserDAO.checkUserCategory(Integer.parseInt(id.toString()));
		if(result == false) return "redirect:/softwareviewer";
		
		return "requestsoftware";
	}
}
