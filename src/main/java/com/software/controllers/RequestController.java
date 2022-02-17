package com.software.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.DAO.RequestDAO;
import com.software.DAO.RequestDAOImpl;
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
	
	@GetMapping("/requestviewer")
	public String redirectRequestViewerPage(Model model, HttpSession session) {
		List<RequestSoftware> listrequest = reqDAO.loadRequests(session.getAttribute("userID").toString());
		model.addAttribute("listrequest", listrequest);
		return "requestviewer";
	}
}
