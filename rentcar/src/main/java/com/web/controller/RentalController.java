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

import com.web.domain.Car;
import com.web.domain.Rental;
import com.web.dto.rentalDTO;
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
	            @RequestParam("endDate") String endDateString,@RequestParam("startTime")
	   			String startTime,Model model) {
	      
	       LocalDate startDate = LocalDate.parse(startDateString);
	       LocalDate endDate = LocalDate.parse(endDateString);
	       Date startDate2 = Date.valueOf(startDate);
	       Date endDate2 = Date.valueOf(endDate);
	      List<Car> cars = carServiceImpl.searchAvailableCars(startDate2, endDate2);
	      long rentalPeriod = rentalService.calRentalPeriod(startDate,endDate);
	      System.out.println(rentalPeriod);
	      rentalDTO rent = rentalDTO.getInstance();
	        rent.setStartDate(startDate2);
	        rent.setEndDate(endDate2);
	        rent.setStartTime(startTime);
	        rent.setRentalPeriod(rentalPeriod);
	      if(rent.isValid()) {
	         model.addAttribute("cars", cars);
	         return "rental";
	      }
	      else {
	         return "rental";
	      }
	   }
	
		
	
	@RequestMapping(value="/rental/save", method=RequestMethod.GET)
	public String rentalSave(Rental rental) {
		rentalService.rent(rental);
		return "rental";
	}
	
	   @GetMapping("/rental/rentCar")
	    public String rentCar(@RequestParam("carNo") long carNo, String startDateString,
	            String endDateString, Model model) {
	      rentalDTO rent = rentalDTO.getInstance();
	      Car cars = carServiceImpl.getCarByCar_no(carNo);
	      rent.setCar_no(cars.getCar_no());
	      rent.setModel(cars.getModel());
	      rent.setModel_year(cars.getModel_year());
	      rent.setTotalCost(cars.getPrice()*rent.getRentalPeriod());
	      model.addAttribute("rent",rent);
	        return "rental-form";
	    }
				
}
