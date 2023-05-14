package com.web.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="car")
public class Car {
   @Id
   @Column(name="car_no",nullable=false,length=8)
   private Long car_no;
   
   @Column(name="model",length=20,nullable=false)
   private String model;
   
   @Column(name="model_year",length=20,nullable=false)
   private String model_year;
   
   @Column(name="price",nullable=false)
   private int price;
   
   @Column(name="imgpath",nullable=false)
   private String imgpath;
   
   
   
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