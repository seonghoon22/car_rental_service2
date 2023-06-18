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


	 @Query("SELECT c FROM Car c WHERE NOT EXISTS (SELECT r FROM Rental r WHERE c.car_no = r.car_no AND r.endDate >= :start AND r.startDate <= :end)")
	List<Car> findAvailableCars(@Param("start") LocalDate startDate, 
                 @Param("end") LocalDate endDate);
	 
//	 @Query("SELECT c FROM Car c WHERE NOT EXISTS (SELECT r FROM Rental r WHERE c.car_no = r.car_no AND r.endDate >= ?1 AND r.startDate <= ?2)")
//	 List<Car> findAvailableCars(LocalDate startDate, LocalDate endDate);
}

