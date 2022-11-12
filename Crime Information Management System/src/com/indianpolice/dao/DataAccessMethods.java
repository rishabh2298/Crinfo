package com.indianpolice.dao;

import java.util.List;

import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.CrimeDetails;
import com.indianpolice.model.CriminalDetails;

public interface DataAccessMethods {
	
	public abstract String addDepartmentDetails() throws DepartmentException;
	
	public abstract String addCrimeDetails() throws CrimeDetailsException;
	
	public abstract String addCriminalDetails() throws CriminalDetailsException;
	
	public abstract List<CriminalDetails> getCriminalDetails(String crimeType) throws CriminalDetailsException;
	
	public abstract List<CrimeDetails> getCrimeDetails(String criminalName) throws CrimeDetailsException;
	
	public abstract List<CrimeDetails> getCrimeRecord(int departmentId) throws CrimeDetailsException;
	
	public abstract List<CriminalDetails> getCriminalRecord(int departmentId) throws CriminalDetailsException;

	public abstract List<CrimeDetails> getFirStatus(String victim) throws CrimeDetailsException;
	
	public abstract List<CrimeDetails> getFirStatusOfDate(String date) throws CrimeDetailsException;
	
	public abstract List<CrimeDetails> getMonthlyCrimeReport(int departmentId,int month,int year) throws DepartmentException;
	
	public abstract List getReportOfDepartment(int departmentId) throws DepartmentException;
	
	public abstract List getCrimeStatus(String status) throws CrimeDetailsException;
	
	public abstract List getCriminalDataBetweenAge(int age1, int age2) throws CriminalDetailsException;
	
	public abstract List getCriminalDataOfAge(int age) throws CriminalDetailsException;
	
	public abstract List getCriminalOfGender(String gender) throws CriminalDetailsException;
	
	public abstract List<CrimeDetails> totalCrime() throws CrimeDetailsException;
	
	public abstract List<CriminalDetails> totalCriminal() throws CriminalDetailsException;
	
}
