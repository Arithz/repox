package com.software.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		
	@GetMapping("/userregister")
	public String redirectUserRegisterPage() {
		return "userregister";
	}
	
	@GetMapping("/requestsoftware")
	public String redirectRequestSoftwarePage() {
		return "requestsoftware";
	}	
	
	@GetMapping("/feedback")
	public String redirectFeedbackPage() {
		return "feedback";
	}
	
	@GetMapping("/login")
	public String redirectLoginPage(HttpSession session) {
		session.setAttribute("userID", null);
		return "login";
	}
	
	@GetMapping("/homepage")
	public String redirectHomePage(HttpSession session) {
		Object id = session.getAttribute("userID");
		if(id == null) return "redirect:/login";
		
//		return "homepage";
		return "redirect:/requestsoftware";
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
	
	@GetMapping("/softwareregister")
	public String redirectSoftwareRegisterPage() {
		return "softwareregister";
	}
}
