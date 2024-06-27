package com.example.demo.controller.fir;


import java.time.LocalDateTime;

import com.example.demo.pojo.district.District;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FIR")

public class Fir {
	@Id
	@Column(name = "fir_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int FIR_Number;
	@Column(name = "current_Date_Time")
	private LocalDateTime  currentDateTime;
	@Column(name = "Place_Of_Occurrence")
	private String placeOccurrence;
	@Embedded
	private Enquiry enquiry;
	 @ManyToOne
	  private District district;
	@Embedded
	private Complainant complainant;
	@Embedded
	private Suspect suspect;
	public Fir() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Fir(int fIR_Number, LocalDateTime currentDateTime, String placeOccurrence, Enquiry enquiry,
			District district, Complainant complainant, Suspect suspect) {
		super();
		FIR_Number = fIR_Number;
		this.currentDateTime = currentDateTime;
		this.placeOccurrence = placeOccurrence;
		this.enquiry = enquiry;
		this.district = district;
		this.complainant = complainant;
		this.suspect = suspect;
	}



	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public int getFIR_Number() {
		return FIR_Number;
	}
	public void setFIR_Number(int fIR_Number) {
		FIR_Number = fIR_Number;
	}
	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}
	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	public String getPlaceOccurrence() {
		return placeOccurrence;
	}
	public void setPlaceOccurrence(String placeOccurrence) {
		this.placeOccurrence = placeOccurrence;
	}
	public Enquiry getEnquiry() {
		return enquiry;
	}
	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}
	public Complainant getComplainant() {
		return complainant;
	}
	public void setComplainant(Complainant complainant) {
		this.complainant = complainant;
	}
	public Suspect getSuspect() {
		return suspect;
	}
	public void setSuspect(Suspect suspect) {
		this.suspect = suspect;
	}
	
	
}
