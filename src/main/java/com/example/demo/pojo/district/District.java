package com.example.demo.pojo.district;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Embeddable
@Entity
@Table(name = "district_name")
public class District {
	@Id
	private int id;
	@Column(name = "district_name",length = 30)
	private String name;
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}
	public District(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
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
	
	

}
