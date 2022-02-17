package com.software.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.software.DAO.SoftwareDAO;
import com.software.DAO.SoftwareDAOImpl;
import com.software.api.Software;

@Controller
public class SoftwareController {
	
	@Autowired
	private SoftwareDAO softwareDAO = new SoftwareDAOImpl();
	
	@GetMapping("/softwareviewer")
	public String redirectRequestViewerPage(Model model, HttpSession session) throws UnsupportedEncodingException {
		List<Software> softwares = softwareDAO.loadSoftwares();
		
		List<String> files = new ArrayList<String>();
		
		for(int i =0; i < softwares.size(); i++) {
			byte[] encodeBase64 = Base64.getEncoder().encode(softwares.get(i).getSwFile());
			String base64DataString = new String(encodeBase64 , "UTF-8");
			files.add(base64DataString);
		}
	
		model.addAttribute("softwares",softwares);
		model.addAttribute("files", files);
		
		return "softwareviewer";
	}
}
