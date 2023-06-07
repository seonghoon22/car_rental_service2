package com.web.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.stereotype.Service;

import com.web.domain.Car;


public interface CarService {
    List<Car> getAllCars();
    Car getCarByCar_no(Long car_no);
    void saveCar(Car car);
}