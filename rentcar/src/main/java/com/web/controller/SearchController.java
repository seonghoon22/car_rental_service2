package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.domain.Car;
import com.web.service.CarService;
import com.web.service.CarServiceImpl;


@Controller
public class SearchController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search() {
		return "search";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchAvailable(Model model) {
		List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
		return "search";
	}
}
