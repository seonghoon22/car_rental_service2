package com.web.repository;
  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.domain.*;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long>{
} 
