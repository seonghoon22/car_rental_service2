package com.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.domain.Car;
import com.web.domain.Rental;
import com.web.service.CarServiceImpl;
import com.web.service.RentalService;


@Controller
public class RentalController {
	
	@Autowired
	private CarServiceImpl carServiceImpl;
	@Autowired
	private RentalService rentalService;
	
	@RequestMapping(value="/rental", method=RequestMethod.GET)
	public String search() {
		return "rental";
	}
	
	
	
	@RequestMapping(value="/rental/search", method=RequestMethod.POST)
	@ResponseBody
	public String searchAvailable(@RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString, Model model) {
		
	    LocalDate startDate = LocalDate.parse(startDateString);
	    LocalDate endDate = LocalDate.parse(endDateString);
		List<Car> cars = carServiceImpl.searchAvailableCars(startDate, endDate);
        model.addAttribute("cars", cars);
        return "rental";
	}
	
	
	
	
	@RequestMapping(value="/rental/save", method=RequestMethod.GET)
	public String rentalSave(Rental rental) {
		rentalService.rent(rental);
		return "rental";
	}
	
	
	
	
}
