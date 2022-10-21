package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.model.CardDetails;
import com.app.model.AdminCredentials;
import com.app.model.UserDetails;
import com.app.model.UserRequests;
import com.app.service.AdminService;


@RestController 
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;

	
	@PostMapping("/signin")
	public String signin(@RequestBody AdminCredentials cred) {	
		AdminCredentials c=service.read(cred.getusername());
		if(c.getusername().matches(cred.getusername()) && c.getpassword().matches(cred.getpassword())) {
			return "Logged in Successfully!!!";
		}
		else {
			return "Invalid Credentials!";
		}		
	}
	
	@GetMapping("/allData")
	public List<CardDetails> viewAllData(){
		return service.getAllCards();
	}
	
	@GetMapping("/pending")
	public List<CardDetails> viewPendingCardReq(){
		return service.PendingReq();		
	}
	
	@GetMapping("/approved")
	public List<CardDetails> viewApprovedCards(){		
		return service.ApprovedReq();		
	}
	
	@GetMapping("/delete/{id}")
	public boolean deleteCard(@PathVariable long id) {
		return service.deleteCard(id);		
	}
	
	@PostMapping("/add")
	public boolean addData(@RequestBody CardDetails card) {
		service.addCard(card);
		return true;
	}
	
	@PostMapping("/updateCard/{id}")
	public void updateState(@RequestBody CardDetails newData) {
		service.updateCardDetails(newData);
	}
	
	@PostMapping("/applyCard")
	public Long applyCard(@RequestBody UserDetails data) {
		CardDetails application = new CardDetails();
		application.setName(data.getName());
		application.setAddress(data.getAddress());
		application.setDob(data.getDob());
		application.setEmail(data.getEmail());
		application.setGender(data.getGender());
		application.setMobile(data.getMobileNo());
		application.setState("Pending");
		service.addCard(application);
		return service.find(data.getName());
		
		
	}
	@PostMapping("/submitRequest")
	public boolean submitRequest(@RequestBody UserDetails ud,String reqName) {
		UserRequests req=new UserRequests();
		req.setName(ud.getName());
		req.setEmail(ud.getEmail());
		req.setAddress(ud.getAddress());
		req.setDob(ud.getDob());
		req.setGender(ud.getGender());
		req.setMobileNo(ud.getMobileNo());
		req.setReqName(reqName);	
		req.setReqState("Pending");
		req.setPass(ud.getPass());
		return service.submitRequest(req);
	}
	
	@GetMapping("/pendingReq")
	public List<UserRequests> viewPending(){
		return service.viewPending();
	}
	
}