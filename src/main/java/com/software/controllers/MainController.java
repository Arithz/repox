package com.software.controllers;

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
	
	@GetMapping("/softwareregister")
	public String redirectSoftwareRegisterPage() {
		return "softwareregister";
	}
	
	@GetMapping("/feedback")
	public String redirectFeedbackPage() {
		return "feedback";
	}
}
