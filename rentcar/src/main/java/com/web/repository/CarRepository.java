package com.web.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.domain.*;

@Repository
public interface CarRepository {
	 List<Car> getAllCarList();
	 Set<Car> getCarListByFilter(Map<String, List<String>> filter);
	 Car getCarById(Long car_no);
	 void setNewCar(Car car);
}
