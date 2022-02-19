package com.software.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.software.DAO.FeedbackDAO;
import com.software.DAO.FeedbackDAOImpl;
import com.software.DAO.UserDAO;
import com.software.DAO.UserDAOImpl;
import com.software.api.Feedback;
import com.software.api.User;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackDAO fbDAO = new FeedbackDAOImpl();
	private UserDAO UserDAO = new UserDAOImpl();
	
	//load all feedback
	@GetMapping("/feedback")
	public String redirectRequestViewerPage(Model model, HttpSession session) {
		List<Feedback> listfeedback = fbDAO.loadFeedbacks();
		List<String> listusername = new ArrayList<String>();
		
		for(int i = 0; i < listfeedback.size(); i++) {
			User u = UserDAO.getUserByID(listfeedback.get(i).getUserID());
			listusername.add(u.getUserName());
		}
		
		model.addAttribute("listfeedback", listfeedback);
		model.addAttribute("listusername", listusername);
		return "feedback";
	}
	
	
	//register new feedback function
	@RequestMapping(value = "/saveFeedback", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute("feedback") Feedback fb, HttpSession session) {
		fbDAO.saveFeedback(fb, session.getAttribute("userID").toString());
		
		return "redirect:/feedback";
	}
	
}
