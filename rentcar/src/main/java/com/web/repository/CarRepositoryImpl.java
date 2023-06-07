package com.web.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import com.web.domain.Car;

public class CarRepositoryImpl implements CarRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Car> findCarsByModel(String model) {
        return entityManager.createQuery("SELECT c FROM Car c WHERE c.model = :model", Car.class)
                .setParameter("model", model)
                .getResultList();
    }


}