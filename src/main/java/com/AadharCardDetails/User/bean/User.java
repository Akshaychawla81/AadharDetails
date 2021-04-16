package com.AadharCardDetails.User.bean;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.stereotype.Component;




@Entity
@Component
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private	int id;

	
	private String name;
	private String address;
	private 	Long aadharNumber;
	@Lob
	private 	byte[] frontImage;
	@Lob
	private 	byte[] backImage;
	private	Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public byte[] getBackImage() {
		return backImage;
	}
	public void setBackImage(byte[] backImage) {
		this.backImage = backImage;
	}
	public Long getAadharNumber() {
		return aadharNumber;
	}
	public void setAahdarNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getFrontImage() {
		return frontImage;
	}
	public void setFrontImage(byte[] frontImage) {
		this.frontImage = frontImage;
	}
	
	
}
