package com.indianpolice.dao;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.indianpolice.exception.CrimeDetailsException;
import com.indianpolice.exception.CriminalDetailsException;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.CrimeDetails;
import com.indianpolice.model.CriminalDetails;

public interface DataAccessMethods {
	
	public abstract List<CriminalDetails> getCriminalDetails(String crimeType) throws CriminalDetailsException;
	
	public abstract List<CrimeDetails> getCrimeDetails(String criminalName) throws CrimeDetailsException;
	
	public abstract List<CrimeDetails> getCrimeRecord(int departmentId) throws CrimeDetailsException;
	
	public abstract List<CriminalDetails> gerCriminalRecord(int departmentId) throws CriminalDetailsException;

	public abstract List getFirStatus(String victim) throws CrimeDetailsException;
	
	public abstract List getFirStatus(LocalDate date) throws CrimeDetailsException;
	
	public abstract List getMonthlyCrimeReport(int departmentId,String month) throws DepartmentException;
	
	public abstract List getReportOfDepartment(int departmentId) throws DepartmentException;
	
	public abstract List getCrimeStatus(String status) throws CrimeDetailsException;
	
	public abstract List getCriminalDataBetweenAge(int age1, int age2) throws CriminalDetailsException;
	
	public abstract List getCriminalDataOfAge(int age) throws CriminalDetailsException;
	
	public abstract List getCriminalOfGender(String gender) throws CriminalDetailsException;
	
	public abstract List<CrimeDetails> totalCrime() throws CrimeDetailsException;
	
	public abstract List<CriminalDetails> totalCriminal() throws CriminalDetailsException;
	
}
