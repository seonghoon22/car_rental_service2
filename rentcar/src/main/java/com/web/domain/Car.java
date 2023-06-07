package com.web.domain;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {
   @Id
   @Column(name = "car_no", nullable = false, length = 8)
   private Long car_no;

   @Column(name = "model", length = 20, nullable = false)
   private String model;

   @Column(name = "model_year", length = 20, nullable = false)
   private String model_year;

   @Column(name = "price", nullable = false)
   private int price;

   @Column(name = "imgpath", nullable = true)
   private String imgpath;

   @Transient
   private MultipartFile file;
 
	public Car() {
		super();
	}

	public Car(Long car_no, String model, String model_year, int price, String imgpath, MultipartFile file) {
		super();
		this.car_no = car_no;
		this.model = model;
		this.model_year = model_year;
		this.price = price;
		this.imgpath = imgpath;
		this.file = file;
	}

	public void setFile(MultipartFile file2) {
		// TODO Auto-generated method stub
		
	}
}
