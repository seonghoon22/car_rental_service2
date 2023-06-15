package com.web.repository;
  
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.domain.*;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByModel(String model);

//    Car findByCar_no(Long car_no);

}

