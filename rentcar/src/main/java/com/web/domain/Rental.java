package com.web.domain;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Rental")
@Getter
@Setter
public class Rental {
       @Id
       @Column(nullable = false)
       private Long rental_no;
       
       @Column(nullable = false)
       private Long car_no;
       
       @Column(nullable = false)
       private String id;
       
       @Column(nullable = false)
       private int year;

       @Column(nullable = false)
       private int month;

       @Column(nullable = false)
       private int day;
       
       @Column(nullable = false)
       private int startTime;
       
       @Column(nullable = false)
       private LocalDate endDate; // 대여 종료일자

       @Column(nullable = false)
       private LocalTime endTime; // 대여 종료시간
       
       public Rental() {
           super();
       }

       public Rental(Long rental_no, Long car_no, String id, int year, int month, int day, int startTime) {
          this.rental_no = rental_no;
           this.car_no = car_no;
           this.id = id;
           this.year = year;
           this.month = month;
           this.day = day;
           this.startTime = startTime;
       }
       
       
       public void setRentalPeriod(int endTime) {
           // 대여 시작일자 및 시간
           LocalDate startDate = LocalDate.of(year, month, day);

           // 대여 종료일자 및 시간
           LocalDate endDate;
           LocalTime endTimeObj;

           if (endTime >= startTime) {
               // 대여 기간이 하루 이내인 경우
               endDate = startDate;
               endTimeObj = LocalTime.of(endTime / 100, endTime % 100);
           } else {
               // 대여 기간이 하루를 초과하는 경우
               endDate = startDate.plusDays((long) ((endTime - startTime) / 100));
               endTimeObj = LocalTime.of(endTime / 100, endTime % 100);
           }

           // 대여 종료일자 및 시간 설정
           this.endDate = endDate;
           this.endTime = endTimeObj;
       }
}