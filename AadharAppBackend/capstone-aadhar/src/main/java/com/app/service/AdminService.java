package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.model.CardDetails;
import com.app.model.AdminCredentials;
import com.app.model.UserRequests;
import com.app.repository.AdminRepository;
import com.app.repository.CardRepository;
import com.app.repository.RequestRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository Repo;
	
	@Autowired
	CardRepository cardRepo;
	
	@Autowired
	RequestRepository reqRepo;
	
	public void create(AdminCredentials cred) {
		Repo.save(cred);		
	}
	
	public List<AdminCredentials> readAll(){
		return (List<AdminCredentials>) Repo.findAll();
	}
	
	public AdminCredentials read(String username) {
		return Repo.findByUsername(username);
	}
	
	public List<CardDetails> getAllCards(){
		return (List<CardDetails>) cardRepo.findAll();
	}
	
	public void updateCardDetails(CardDetails newCardData) {
		Optional<CardDetails> oldData=cardRepo.findById(newCardData.getCitizenId());
		cardRepo.save(newCardData);
	}
	
	public boolean deleteCard(long citizenId) {
		cardRepo.deleteById(citizenId);
		return true;
	}
	
	public boolean addCard(CardDetails data) {
		cardRepo.save(data);
		return true;
	}
	
	public List<CardDetails> PendingReq(){
		return cardRepo.findByState("Pending");
	}
	
	public List<CardDetails> ApprovedReq(){
		return cardRepo.findByState("Approved");
	}
	
	public long find(String name) {
		return cardRepo.findByName(name).getCitizenId();		
	}
	
	public Iterable<UserRequests> allUserRequests() {
		return reqRepo.findAll(); 		
	}
	
	public boolean submitRequest(UserRequests req) {
		reqRepo.save(req);
		return true;
	}
	
	public List<UserRequests> viewPending(){
		return reqRepo.findByReqState("Pending");
	}
	
}
