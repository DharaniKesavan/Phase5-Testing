package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.model.UserCredentials;

@Repository
public interface UserRepository extends JpaRepository<UserCredentials, Long> {
	UserCredentials findByEmail(String email);
}