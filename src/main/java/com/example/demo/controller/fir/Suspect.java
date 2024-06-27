package com.example.demo.controller.fir;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Suspect {
	@Column(name="Suspact_Name")
	private String name;
	@Column(name="Suspact_Adress")
	private String address;
	public Suspect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suspect(String name, String address) {
		super();
		this.name = name;
		this.address = address;
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
	
	
}
