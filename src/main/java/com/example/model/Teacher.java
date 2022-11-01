package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String identification;
	private String name;
	private String dateOfBirth;
	private String address;
	private String gender;
	private String phoneNumber;
	private String email;
	private String subjects;
	private Boolean active;
	
	
	
	public Teacher(Long id, String identification, String name, String dateOfBirth, String address, String gender,
			String phoneNumber, String email, String subjects, Boolean active) {
		this.id = id;
		this.identification = identification;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.subjects = subjects;
		this.active = active;
	}

	public Teacher() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIdentification() {
		return identification;
	}
	
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSubjects() {
		return subjects;
	}
	
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}
