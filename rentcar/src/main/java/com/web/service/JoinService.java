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
         
         //아이디 중복 검사
         if(isIdDuplicated(userDto.getId())) {
            throw new  IllegalArgumentException("Duplicate ID");
         }
         
         // user entity로 저장
         User user = createUserFromDto(userDto);
         userRepository.save(user);
         }
      
         // 중복 검사 메서드
         public boolean isIdDuplicated(String id) {
            //아이디 사용자 조회
            User user = userRepository.findById(id);
            
            return user != null; // 사용자가 존재하면 중복된 아이디로 판단
          }
         
         private User createUserFromDto(userDTO userDto) {
                  
	         User user = new User();
	           user.setId(userDto.getId());
	           user.setName(userDto.getName());
	           user.setPassword(userDto.getPassword());
	           user.setAge(userDto.getAge());
	           user.setAddress(userDto.getAddress());
	           user.setPhone(userDto.getPhone());
	           
	           return user;   //user entity
      }        
}
