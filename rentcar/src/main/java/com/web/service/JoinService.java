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
//	   @Autowired
//	   BCryptPasswordEncoder passwordEncoder;
//	   
//	   public String rawPw;
//	   public String encodedPw;
	   
	   public void join(User user) {
//		   rawPw = user.getPassword();
//		   encodedPw = passwordEncoder.encode(user.getPassword());
//		   user.setPassword(encodedPw);
		   userRepository.save(user);
	   }
	   
//	   public boolean athenticate(String rawPw, String encodedPw) {
//		   return passwordEncoder.matches(rawPw, encodedPw);
//	   }
	   
	    public boolean isIdDuplicated(String id) {
	    	return userRepository.existsById(id);
	    }
}
