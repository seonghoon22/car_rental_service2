package com.web.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class rentalDTO {
    private Long car_no;
    private String model;
    private String model_year;
    private int price;
    private long id;
    private long rentalPeriod;
    private long totalCost;
    private Date startDate;
    private String startTime;
    private Date endDate;

    private static rentalDTO instance;

    private rentalDTO() {
    }

    public static rentalDTO getInstance() {
        if (instance == null) {
            instance = new rentalDTO();
        }
        return instance;
    }

    public boolean isValid() {
        Date today = new Date();
        if (startDate == null || endDate == null) {
            return false;
        }
        if (startDate.before(today)) {
            return false;
        }
        if (endDate.before(startDate)) {
            return false;
        }
        return true;
    }


}