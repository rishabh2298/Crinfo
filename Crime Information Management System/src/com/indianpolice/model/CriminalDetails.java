package com.indianpolice.model;

public class CriminalDetails {
	
	private String name;
	private int age;
	private String gender;
	private String address;
	private String identifyMark;
	private String arrestedArea;
	private String crimeType;
	private int departmentId;
	
	public CriminalDetails() {
	
	}

	public CriminalDetails(String name, int age, String gender, String address, String identifyMark,
			String arrestedArea, String crimeType, int departmentId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identifyMark = identifyMark;
		this.arrestedArea = arrestedArea;
		this.crimeType = crimeType;
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentifyMark() {
		return identifyMark;
	}

	public void setIdentifyMark(String identifyMark) {
		this.identifyMark = identifyMark;
	}

	public String getArrestedArea() {
		return arrestedArea;
	}

	public void setArrestedArea(String arrestedArea) {
		this.arrestedArea = arrestedArea;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}
