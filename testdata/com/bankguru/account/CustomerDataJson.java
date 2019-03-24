package com.bankguru.account;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerDataJson {
	public static CustomerDataJson get(String nameFile) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(nameFile), CustomerDataJson.class);
	}

	@JsonProperty("name")
	String name;
	
	@JsonProperty("password")
	String password;
	
	@JsonProperty("customerName")
	String customerName;
	
	@JsonProperty("dateOfBirth_chrome")
	String dateOfBirth_chrome;
	
	@JsonProperty("dateOfBirth")
	String dateOfBirth;
	
	@JsonProperty("address")
	String address;
	
	@JsonProperty("city")
	String city;
	
	
	@JsonProperty("state")
	String state;
	
	@JsonProperty("pin")
	String pin;
	
	@JsonProperty("mobile")
	String mobile;
	
	@JsonProperty("pass")
	String pass;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth_chrome() {
		return dateOfBirth_chrome;
	}

	public void setDateOfBirth_chrome(String dateOfBirth_chrome) {
		this.dateOfBirth_chrome = dateOfBirth_chrome;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}

