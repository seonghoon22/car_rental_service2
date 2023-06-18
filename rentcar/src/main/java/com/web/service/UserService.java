package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.domain.User;
import com.web.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	public User showUser(String id) {		
		
		return  userrepository.findById(id);
	}
}
