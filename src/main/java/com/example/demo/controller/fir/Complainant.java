package com.example.demo.controller.fir;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class Complainant {
	@Column(name = "Comname",length = 50)
	private String coname;
	@Column(name = "date_of_birth")
	private Date dob;
	@Column(name = "Aadhaar_Number",length = 12)
	private String aadharNumber;
	@Column(name = "occupation")
	private String occupation;
	@Column(name = "Mobile_Number",length = 10)
	private String mobileNumber;
	@Column(name = "Nationality")
	private String nationality;
	@Column(name = "Address")
	private String address;
	@Column(name = "Information")
	private Information information;
	public Complainant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Complainant(String coname, Date dob, String aadharNumber, String occupation, String mobileNumber,
			String nationality, String address, Information information) {
		super();
		this.coname = coname;
		this.dob = dob;
		this.aadharNumber = aadharNumber;
		this.occupation = occupation;
		this.mobileNumber = mobileNumber;
		this.nationality = nationality;
		this.address = address;
		this.information = information;
	}


	public String getConame() {
		return coname;
	}


	public void setConame(String coname) {
		this.coname = coname;
	}


	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Information getInformation() {
		return information;
	}
	public void setInformation(Information information) {
		this.information = information;
	}
	
	
}
