package com.web.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@RequestMapping(value="/rental/loginindex", method=RequestMethod.GET)
	public String loginindex() {
		return "loginindex";
	}
	
	@RequestMapping(value="/rental", method=RequestMethod.GET)
	public String search() {
		
			return "rental";
	}
	
	
	
	@RequestMapping(value="/rental/search", method=RequestMethod.POST)
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
	
	@GetMapping("/rental/rentCar")
    public String rentCar(@RequestParam("carNo") long carNo,@RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString,Model model) {
			
			Car cars = carServiceImpl.getCarByCar_no(carNo);
			model.addAttribute("cars",cars);
        return "rental-form";
    }
				
}
