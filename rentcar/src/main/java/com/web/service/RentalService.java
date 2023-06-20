package com.web.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.domain.Rental;
import com.web.repository.RentalRepository;

@Service
public class RentalService {
	
	   @Autowired
	   private RentalRepository rentalRepository;
	   
	   
	   public void rent(Rental rental) {
		   rentalRepository.save(rental);
	   }
	   
	   public long calRentalPeriod(LocalDate startDate,LocalDate endDate) {
		   
		   long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		   	
		   return daysBetween;
	   }
	   
}