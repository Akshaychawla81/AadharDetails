package com.AadharCardDetails.User.bean;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



@Entity
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private	int id;

	
	private String name;
	private String address;
	private 	Long aadharNumber;
	private 	byte[] frontImage;
	
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
	@Lob
	public byte[] getFrontImage() {
		return frontImage;
	}
	public void setFrontImage(byte[] frontImage) {
		this.frontImage = frontImage;
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
	
	
}
