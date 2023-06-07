package com.web.repository;

import java.util.List;

import com.web.domain.Car;

public interface CarRepositoryCustom {

	List<Car> findCarsByModel(String model);

}
