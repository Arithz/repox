package com.software.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String redirect() {
		return "index";
	}

	@GetMapping("/index")
	public String redirectIndex() {
		return "index";
	}
	
	@GetMapping("/userPage")
	public String redirectUserPage() {
		return "userPage";
	}
	
	@GetMapping("/adminPage")
	public String redirectAdminPage() {
		return "adminPage";
	}
		
	@GetMapping("/userregister")
	public String redirectUserRegisterPage() {
		return "userregister";
	}
	
	@GetMapping("/requestsoftware")
	public String redirectRequestSoftwarePage() {
		return "requestsoftware";
	}	
	
	@GetMapping("/login")
	public String redirectLoginPage(HttpSession session) {
		session.setAttribute("userID", null);
		return "login";
	}
	
	@GetMapping("/userhomepage")
	public String redirectHomePage(HttpSession session) {
		Object id = session.getAttribute("userID");
		if(id == null) return "redirect:/login";
		
		//return "userhomepage";
		return "redirect:/softwareviewer";
	}
	
	@GetMapping("/categoryregister")
	public String redirectCategoryRegisterPage() {
		return "categoryregister";
	}
	
	// ADMIN REDIRECT //
	@GetMapping("/adminregister")
	public String redirectAdminRegisterPage(HttpSession session) {
		return "adminregister";
	}
	
	@GetMapping("/loginAdmin")
	public String redirectLoginAdminPage(HttpSession session) {
		session.setAttribute("adminID", null);
		return "loginAdmin";
	}
	
	@GetMapping("/saveSoftware")
	public String redirectSaveSoftwarePage() {
		return "softwareregister";
	}
	
	@GetMapping("/softwareEdit")
	public String redirectSoftwareEditPage() {
		return "softwareEdit";
	}
}
