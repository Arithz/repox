package com.software.rest;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.software.DAO.CategoryDAO;
import com.software.DAO.CategoryDAOImpl;
import com.software.DAO.FeedbackDAO;
import com.software.DAO.FeedbackDAOImpl;
import com.software.DAO.RequestDAO;
import com.software.DAO.RequestDAOImpl;
import com.software.DAO.SoftwareDAO;
import com.software.DAO.SoftwareDAOImpl;
import com.software.api.Category;
import com.software.api.Feedback;
import com.software.api.RequestSoftware;
import com.software.api.Software;

@RestController
public class RESTController {
	
	@Autowired
	private CategoryDAO categoryDAO = new CategoryDAOImpl();
	private RequestDAO reqDAO = new RequestDAOImpl();
	private SoftwareDAO softwareDAO = new SoftwareDAOImpl();
	private FeedbackDAO fbDAO = new FeedbackDAOImpl();
	
	// SOFTWARE CONTROLLER API //
    @GetMapping("api/software")
    public List<Software> getAllSoftwares() {
        return softwareDAO.loadSoftwares();
    }
	
	// REQUEST CONTROLLER API //
    @GetMapping("api/request")
    public List<RequestSoftware> getAllRequests() {
        return reqDAO.loadAllRequests();
    }
    
    @GetMapping("api/request/{id}")
    public RequestSoftware getRequest(@PathVariable int id) {
        return reqDAO.getRequestByID(id);
    }
	
	// CATEGORY CONTROLLER API //
	//load all category
    @GetMapping("api/category")
    public List<Category> getAllCategory() {
        return categoryDAO.loadCategory();
    }
    
    //get category by id
    @GetMapping("api/category/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryDAO.getCategory(id);
    }
    
	// FEEDBACK CONTROLLER API //
	//load all category
    @GetMapping("api/feedback")
    public List<Feedback> getAllFeedbacks() {
        return fbDAO.loadFeedbacks();
    }
    
    //get category by id
    @GetMapping("api/feedback/{id}")
    public Feedback getFeedback(@PathVariable int id) {
        return fbDAO.getFeedbackByID(id);
    }
}
