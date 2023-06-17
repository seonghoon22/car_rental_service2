package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.domain.Rental;
import com.web.repository.RentalRepository;

@Service
public class RentalService {
	
	   @Autowired
	   private RentalRepository rentalRepository;
	   
	  
	   public void CalcToTal(Rental rental) {
	   }
	   
	   public void rent(Rental rental) {
		   rentalRepository.save(rental);
	   }
}