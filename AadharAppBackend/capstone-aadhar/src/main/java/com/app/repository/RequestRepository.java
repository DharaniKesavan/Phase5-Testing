package com.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.UserRequests;

public interface RequestRepository extends JpaRepository<UserRequests, Long>{
	List<UserRequests> findByReqState(String state);
}