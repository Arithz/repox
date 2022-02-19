package com.software.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.software.DAO.AdminDAO;
import com.software.DAO.AdminDAOImpl;
import com.software.DAO.RequestDAO;
import com.software.DAO.RequestDAOImpl;
import com.software.DAO.UserDAO;
import com.software.DAO.UserDAOImpl;
import com.software.api.Admin;
import com.software.api.RequestSoftware;
import com.software.api.User;

@Controller
public class RequestController {
	
	@Autowired
	private RequestDAO reqDAO = new RequestDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	
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
	
	@GetMapping("/adminRequestList")
	public String redirectAdminRequestPage(Model model, HttpSession session) {
		List<RequestSoftware> listrequest = reqDAO.loadAdminRequests();
		List<User> listuser = new ArrayList<User>();
				
		for(int i = 0; i<listrequest.size(); i++) {
			User user = userDAO.getUserByID(listrequest.get(i).getUserID());
			listuser.add(user);
		}

		model.addAttribute("listrequest", listrequest);
		model.addAttribute("listuser", listuser);
		return "adminRequestList";
	}
	
	//reject request
	@RequestMapping(value = "rejectsw/{reqID}", method = RequestMethod.GET)
	public String registersoftwarefromrequest(@PathVariable("reqID") int reqID) {
		reqDAO.rejectRequest(reqID);
		return "redirect:/adminRequestList";
	}
	
}
