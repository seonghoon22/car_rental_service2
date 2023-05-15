package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.domain.User;
import com.web.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @Autowired
       private LoginService loginService;

       @GetMapping("/login")
       public String login() {
           return "login";
       }

       @PostMapping("/login")
       public String loginId(@ModelAttribute User user) {
           if(loginService.login(user)){
               return "redirect:/";
           }
           return "login";
       }
}