package com.web.repository;
  
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByModel(String model);
//    @Query("SELECT c FROM Car c WHERE c.car_no NOT IN (SELECT r.car_no FROM Rental r WHERE r.endDate >= CURRENT_DATE AND r.startDate <= :endDate)")
    @Query("SELECT c FROM Car c ")
    List<Car> findAvailableCars();

}