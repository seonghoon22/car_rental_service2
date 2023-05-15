package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.domain.User;
import com.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JoinService {
	   @Autowired
	   private UserRepository userRepository;
	   
	   public void join(User user) {
		   userRepository.save(user);	   	
	   }
	   
	    public boolean isIdDuplicated(String id) {
	    	return userRepository.existsById(id);
	    }
}
