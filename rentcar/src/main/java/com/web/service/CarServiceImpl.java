package com.web.service;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.web.domain.Car;
import com.web.repository.CarRepository;

@Service
								//extends
public class CarServiceImpl implements CarService{
	 @Autowired
	 private CarRepository carRepository;
	 
	 public List<Car> getAllCarList() { 
	        // TODO Auto-generated method stub
		 return carRepository.getAllCarList();
	 } 
	 
	 
	 public Set<Car> getCarListByFilter(Map<String, List<String>> filter) {
	      Set<Car> carByFilter = carRepository.getCarListByFilter(filter); 
	      return carByFilter;
	 }
	 
	 public Car getCarById(Long car_no) {
	        Car CarById = carRepository.getCarById(car_no);
	        return CarById;
	 }
	 
	 public void setNewCar(Car car) {  
	        carRepository.setNewCar(car);  
	 }  
	 
}
