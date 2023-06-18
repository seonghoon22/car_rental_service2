package com.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.web.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findById(String id);
}
