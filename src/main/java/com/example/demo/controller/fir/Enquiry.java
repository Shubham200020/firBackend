package com.example.demo.controller.fir;

import jakarta.persistence.Embeddable;

@Embeddable
public class Enquiry {
	
	private String name;
	private Role role;
	public Enquiry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enquiry(String name, Role role) {
		super();
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
