package com.app.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.app.model.UserCredentials;
import com.app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository Repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String login(String email, String pass) {		
		UserCredentials uCred= Repo.findByEmail(email);
		if(uCred==null){
			return "Kindly enter the values!";
		}
		
		if(uCred.getEmail().matches(email)&&uCred.getPass().matches(pass))
			return "User Logged in Successfully!!!";
		else
			return "Invalid Credentials!";		
	}
	
	public String register(UserCredentials uCred) {
		Repo.save(uCred);
		return "New User Registered Successfully!!!";
	}
	
	public Iterable<UserCredentials> getAll(){
		return Repo.findAll();
	}
	
	public Long applyAadhar(UserCredentials userCred) {
		String url="http://localhost:8080/admin/applyCard";
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<UserCredentials> entity = new HttpEntity<UserCredentials>(userCred,headers);
	    return restTemplate.exchange(url, HttpMethod.POST, entity, Long.class).getBody();	
	}
	
	public boolean sendRequest(UserCredentials userCred,String reqName) {
		String url="http://localhost:8080/admin/submitRequest";
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<UserCredentials> entity = new HttpEntity<UserCredentials>(userCred,headers);
	    Map<String, String> map = new HashMap<>();
	    map.put("reqName", reqName);
		return restTemplate.exchange(url, HttpMethod.POST, entity, Boolean.class, map).getBody();
		
	}

}