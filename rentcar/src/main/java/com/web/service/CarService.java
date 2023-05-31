package com.web.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.web.domain.Car;

@Service
public interface CarService {
	List<Car> getAllCarList();
	//filter?
	Set<Car> getCarListByFilter(Map<String, List<String>> filter);
	Car getCarById(Long car_no);
	void setNewCar(Car car);
}
