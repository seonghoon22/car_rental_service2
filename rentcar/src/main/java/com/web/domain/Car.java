package com.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @ColumnDefault("0")
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
	/*
	public void setFile(MultipartFile file) {
		// TODO Auto-generated method stub
		this.file = file;
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
	*/
	public MultipartFile getFile() {
	      return file;
	   }

	   public void setFile(MultipartFile file) {
	      this.file = file;
	   }

	   public Long getCar_no() {
	      return car_no;
	   }

	   public void setCar_no(Long car_no) {
	      this.car_no = car_no;
	   }

	   public String getModel() {
	      return model;
	   }

	   public void setModel(String model) {
	      this.model = model;
	   }

	   public String getModel_year() {
	      return model_year;
	   }

	   public void setModel_year(String model_year) {
	      this.model_year = model_year;
	   }

	   public int getPrice() {
	      return price;
	   }

	   public void setPrice(int price) {
	      this.price = price;
	   }
	   
	   public String getImgpath() {
	      return imgpath;
	   }

	   public void setImgpath(String imgpath) {
	      this.imgpath = imgpath;
	   }

	
}
