package com.web.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;



@Entity
@Table(name="user")
public class User{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @ColumnDefault("0")
   private int user_no;
   
   @Column(name="id", nullable=false)
   private String id;
   
   @Column(name="password",nullable=false)
   private String password;

   @Column(name="name",nullable=false,length=20)
   private String name;
   
   @Column(name="age",nullable=false)
   private int age;
   
   @Column(name="address",nullable=false,length=100)
   private String address;
   
   @Column(name="phone",nullable=false,length=13)
   private String phone;


public int getUser_no() {
	return user_no;
}

public void setUser_no(int user_no) {
	this.user_no = user_no;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}
  
}