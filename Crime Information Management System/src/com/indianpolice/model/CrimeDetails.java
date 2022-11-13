package com.indianpolice.model;

public class CrimeDetails {
	
	private String date;
	private String place;
	private String crimeType;
	private String victim;
	private String crimeDescription;
	private String mainSuspect;
	private int departmentId;
	private String status;
	
	public CrimeDetails() {

	}

	public CrimeDetails(String date, String place, String crimeType, String victim, String crimeDescription,
			String mainSuspect, int departmentId, String status) {
		super();
		this.date = date;
		this.place = place;
		this.crimeType = crimeType;
		this.victim = victim;
		this.crimeDescription = crimeDescription;
		this.mainSuspect = mainSuspect;
		this.departmentId = departmentId;
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getVictim() {
		return victim;
	}

	public void setVictim(String victim) {
		this.victim = victim;
	}

	public String getCrimeDescription() {
		return crimeDescription;
	}

	public void setCrimeDescription(String crimeDescription) {
		this.crimeDescription = crimeDescription;
	}

	public String getMainSuspect() {
		return mainSuspect;
	}

	public void setMainSuspect(String mainSuspect) {
		this.mainSuspect = mainSuspect;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CrimeDetails [date=" + date + ", place=" + place + ", crimeType=" + crimeType + ", victim=" + victim
				+ ", crimeDescription=" + crimeDescription + ", mainSuspect=" + mainSuspect + ", departmentId="
				+ departmentId + ", status=" + status + "]";
	}

}
