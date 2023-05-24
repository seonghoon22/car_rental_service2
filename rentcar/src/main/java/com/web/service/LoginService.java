package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.domain.User;
import com.web.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
   @Autowired
    private UserRepository userRepository;
   
    public boolean login(User user) {
        User findUser = userRepository.findById(user.getId());
        if(findUser == null){
            return false;
        }
        if(!findUser.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;

    }
}