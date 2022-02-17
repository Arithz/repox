package com.software.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.DAO.RequestDAO;
import com.software.DAO.RequestDAOImpl;
import com.software.DAO.UserDAO;
import com.software.api.RequestSoftware;

@Controller
public class RequestController {
	
	@Autowired
	private RequestDAO reqDAO = new RequestDAOImpl();
	
	@RequestMapping(value = "/registerNewRequest", method = RequestMethod.POST)
	public String requestsoftwareRegister(@ModelAttribute("request") RequestSoftware req, HttpSession session) {
		reqDAO.saveRequest(req, session.getAttribute("userID").toString());
		return "redirect:/requestsoftware";
	}
}
