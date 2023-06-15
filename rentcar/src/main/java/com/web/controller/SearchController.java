package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.service.CarServiceImpl;


@Controller
public class SearchController {
	
	@Autowired
	private CarServiceImpl s;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		return "search";
	}

}
