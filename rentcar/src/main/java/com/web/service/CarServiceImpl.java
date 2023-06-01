package com.web.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.web.domain.Car;
import com.web.repository.CarRepository;



@Service					
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
	        return carRepository.getCarById(car_no);
	 }
	 
	 public void setNewCar(Car car) {
	        if (car.getFile() != null && !car.getFile().isEmpty()) {
	            String uploadDir = "C:\\upload";
	            String fileName = car.getCar_no() + ".png";
	            String filePath = Paths.get(uploadDir, fileName).toString();

	            try {
	                byte[] bytes = car.getFile().getBytes();
	                Path path = Paths.get(filePath);
	                Files.write(path, bytes);
	                car.setImgpath(filePath);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	        carRepository.setNewCar(car);
	    }
	}