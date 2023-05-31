package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.dto.userDTO;
import com.web.domain.User;
import com.web.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JoinService {
	   @Autowired
	   private UserRepository userRepository;

	   public void join(userDTO userDto) {
	        User user = new User();
	        user.setId(userDto.getId());
	        user.setName(userDto.getName());
	        user.setPassword(userDto.getPassword());
	        user.setAge(userDto.getAge());
	        user.setAddress(userDto.getAddress());
	        user.setPhone(userDto.getPhone());

	        userRepository.save(user);
	   }
	   
	   
	   public boolean isIdDuplicated(String id) {
		   User user = userRepository.findById(id);
		   return user != null;
	    }
}
