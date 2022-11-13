package com.indianpolice.model;

public class Department {
	
	private int departmentId;
	private String area;
	private String city;
	private String state;
	private String zone;
	
	public Department() {
		
	}

	public Department(int departmentId, String area, String city, String state, String zone) {
		super();
		this.departmentId = departmentId;
		this.area = area;
		this.city = city;
		this.state = state;
		this.zone = zone;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", zone=" + zone + "]";
	}

}
