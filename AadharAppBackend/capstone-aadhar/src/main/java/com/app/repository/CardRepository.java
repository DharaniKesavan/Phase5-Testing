package com.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.model.CardDetails;

public interface CardRepository extends JpaRepository<CardDetails,Long> {
	List<CardDetails> findByState(String state);
	CardDetails findByName(String name);
}
