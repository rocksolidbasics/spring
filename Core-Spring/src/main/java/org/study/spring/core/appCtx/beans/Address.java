package org.study.spring.core.appCtx.beans;

import java.beans.ConstructorProperties;

public class Address {

	private String street;
	private String state;
	private String country;
	
	@ConstructorProperties({"street", "state", "ctry"})
	public Address(String st, String state, String country) {
		this.street = st;;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String steet) {
		this.street = steet;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
