package com.bankguru.account;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EditCustomerDataJson {
	public static EditCustomerDataJson get(String nameFile) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(nameFile), EditCustomerDataJson.class);
	}

	
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
	
}

