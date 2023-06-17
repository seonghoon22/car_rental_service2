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
	
	public MultipartFile getFile() {
	      return file;
	   }

	   public void setFile(MultipartFile file) {
	      this.file = file;
	   }


}
