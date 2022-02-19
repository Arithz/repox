package com.software.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.software.DAO.CategoryDAO;
import com.software.DAO.CategoryDAOImpl;
import com.software.DAO.RequestDAO;
import com.software.DAO.RequestDAOImpl;
import com.software.DAO.SoftwareDAO;
import com.software.DAO.SoftwareDAOImpl;
import com.software.api.Category;
import com.software.api.RequestSoftware;
import com.software.api.Software;

@Controller
public class SoftwareController {
	
	@Autowired
	private SoftwareDAO softwareDAO = new SoftwareDAOImpl();
	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	private RequestDAO requestDAO = new RequestDAOImpl();

	
	// DOWNLOAD CONTROL //
	@RequestMapping(value = "download/{swid}", method = RequestMethod.GET)
	public String addDownloadHistory(@PathVariable("swid") int swid, HttpSession session) {
		softwareDAO.addHistory(swid,Integer.parseInt(session.getAttribute("userID").toString()));
		return "redirect:/softwareviewer";
	}
	
	
	//submit form to save the software
	@RequestMapping(value = "/saveSoftware", method = RequestMethod.POST)
	public String userRegister(@RequestParam("reqID") int reqID, @RequestParam("swName") String swName, @RequestParam("swVersion") double swVersion, @RequestParam("swDescription") String swDescription, @RequestParam("categoryID") int categoryID, @RequestParam("swFile") MultipartFile file) throws IOException {
		Software software = new Software();
		software.setSwName(swName);
		software.setSwVersion(swVersion);
		software.setSwDescription(swDescription);
		software.setCategoryID(categoryID);
		
		try {
			String result = Base64.getEncoder().encodeToString(file.getBytes());
			result = hex(file.getBytes());
			softwareDAO.saveSoftware(software, result);
			
			if(reqID != 0) {
				requestDAO.acceptRequest(reqID);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/softwareregister";
	}
	
//    public static String base64ToHex(String value) throws UnsupportedEncodingException {
//        String hexValue = null;
//        if (value != null) {
//            hexValue = new String(Hex.encodeHex(Base64.getDecoder().decode(value.getBytes("UTF-8"))));
//        }
//        return hexValue;
//    }
	
	public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }
	
	//register software form
	@GetMapping("/softwareregister")
	public String redirectSoftwareRegisterPage(Model model) {
		List<Category> listcategory = categoryDAO.loadCategory();
		model.addAttribute("categories",listcategory);
		return "softwareregister";
	}
	
	//register software from request pending
	@RequestMapping(value = "sofwareregister/{reqID}", method = RequestMethod.GET)
	public String registersoftwarefromrequest(@PathVariable("reqID") int reqID, RedirectAttributes redirectAttributes) {
		RequestSoftware req = requestDAO.getRequestByID(reqID);
		redirectAttributes.addFlashAttribute("request", req);
		return "redirect:/softwareregister";
	}
	
	//get list of all softwares
	@GetMapping("/softwareviewer")
	public String redirectRequestViewerPage(Model model, HttpSession session) throws IOException {
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
	
	//get all softwares of the admins
	@GetMapping("/adminswlist")
	public String redirectAdminSwListPage(Model model, HttpSession session) throws UnsupportedEncodingException {
		List<Software> softwares = softwareDAO.loadSoftwares();
		
		List<Category> categories = new ArrayList<Category>();
		
		for(int i =0; i < softwares.size(); i++) {
			Category category = categoryDAO.getCategory(softwares.get(i).getCategoryID());
			categories.add(category);
		}
	
		model.addAttribute("softwares",softwares);
		model.addAttribute("categories", categories);
		
		return "adminswlist";
	}
	
	//update the values from the software
	@RequestMapping(value = "editsw/{swID}", method = RequestMethod.GET)
	public String editredirect(@PathVariable("swID") int swID, RedirectAttributes redirectAttributes) {
		Software softwares = softwareDAO.getSoftwareById(swID);
		redirectAttributes.addAttribute("swID", swID);
		redirectAttributes.addFlashAttribute("softwares", softwares);
		return "redirect:/softwareEdit";
	}

	//update sw values to the database function
	@RequestMapping(value = "/updatesw", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("software") Software software) {
		softwareDAO.update(software);
		return "redirect:/adminswlist";
	}
		
	//delete software
	@RequestMapping(value = "checksoftware/{swID}",method = RequestMethod.GET)
	public String checkData(@PathVariable("swID") int swID, RedirectAttributes redirectAttributes) {
		List<Software> software = softwareDAO.checkSwAvailabletoDelete(swID);
		if(software.get(0).getSwID() == 0) {
			Software deletesoftware = softwareDAO.getSoftwareById(swID);
			softwareDAO.delete(deletesoftware);
			return "redirect:/adminswlist";
		}else {
			String alert = "Software cannot be deleted as it is in download history";
			redirectAttributes.addFlashAttribute("alert", alert);
			return "redirect:/adminswlist";
		}
	}
}
