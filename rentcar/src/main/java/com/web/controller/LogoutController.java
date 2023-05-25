package com.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

public class LogoutController {

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        System.out.println(session.getAttribute("userid"));
	        return "index";
	}
}