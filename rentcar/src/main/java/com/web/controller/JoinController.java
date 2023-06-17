package com.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dto.userDTO;
import com.web.service.JoinService;


@Controller
public class JoinController {
	@Autowired
	private JoinService service;
	 
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String index(userDTO userDto) {
		return "join";
	}
	 

	@PostMapping("/join")
	public String joinOk(@ModelAttribute @Valid userDTO userDto, BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()) {
			return "join";
		}
		service.join(userDto);
		return "redirect:/";
	}
	
    @GetMapping("/checkDuplicateId")
    public String checkDuplicateId(@Valid @RequestParam("id") String id) {
    	boolean isDuplicate = service.isIdDuplicated(id);
        return isDuplicate ? "true" : "false";
    }
	
}