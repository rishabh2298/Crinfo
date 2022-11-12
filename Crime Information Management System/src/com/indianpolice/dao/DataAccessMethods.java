package com.indianpolice.dao;

import java.util.List;

import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.CrimeDetails;
import com.indianpolice.model.CriminalDetails;
import com.indianpolice.model.Department;

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
	
	public abstract List<CrimeDetails> getCrimeStatus(String status) throws CrimeDetailsException;
	
	public abstract List<CriminalDetails> getCriminalDataOfAge(int age) throws CriminalDetailsException;
	
	public abstract List<CriminalDetails> getCriminalDataBetweenAge(int age1, int age2) throws CriminalDetailsException;
	
	public abstract List<CriminalDetails> getCriminalOfGender(String gender) throws CriminalDetailsException;
	
	public abstract List<CrimeDetails> totalCrime() throws CrimeDetailsException;
	
	public abstract List<CriminalDetails> totalCriminal() throws CriminalDetailsException;
	
	public abstract Department editDepartment(String id) throws DepartmentException;
	
	public abstract CriminalDetails editCriminalDetails(String id, String criminalName, int criminalAge) throws CriminalDetailsException;
	
	public abstract CrimeDetails editCrimeDetails(String id, String crime_type, String victim) throws CrimeDetailsException; 
	
}
