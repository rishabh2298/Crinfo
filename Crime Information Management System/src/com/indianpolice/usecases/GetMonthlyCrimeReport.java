package com.indianpolice.usecases;

import java.util.List;
import java.util.Scanner;

import com.indianpolice.dao.DataAccessMethods;
import com.indianpolice.dao.DataAccessMethodsImpl;
import com.indianpolice.exception.DepartmentException;
import com.indianpolice.model.CrimeDetails;

public class GetMonthlyCrimeReport {
	
	public void values() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter department-id which you want report");
		int departmentId = input.nextInt();
		
		System.out.println("Enter month(number) you want report");
		int month = input.nextInt();
		
		System.out.println("Enter year");
		int year = input.nextInt();
		
		DataAccessMethods dao = new DataAccessMethodsImpl();
		
		
		try {
		
			List<CrimeDetails> crimes = dao.getMonthlyCrimeReport(departmentId, month, year);
			
			crimes.forEach(s -> {
				System.out.println();
				System.out.println("Date = "+s.getDate());
				System.out.println("Place = "+s.getPlace());
				System.out.println("Crime Type = "+s.getCrimeType());
				System.out.println("Victim = "+s.getVictim());
				System.out.println("Crime Description = "+s.getCrimeDescription());
				System.out.println("Main suspect = "+s.getMainSuspect());
				System.out.println("Department Id = "+s.getDepartmentId());
				System.out.println("Status = "+s.getStatus());
				System.out.println("=================================================");
			});
			
		} catch (DepartmentException e) {

			System.out.println(e.getMessage());
		}
		
		input.close();
	}

}
